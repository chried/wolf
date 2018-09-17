package com.wolf89.wolf.service.user.impl;

import com.wolf89.wolf.core.output.ApiOutput;
import com.wolf89.wolf.core.service.AbstractServiceImpl;
import com.wolf89.wolf.dao.system.LoginErrorCacheRepository;
import com.wolf89.wolf.dto.user.LoginForm;
import com.wolf89.wolf.model.cache.LoginErrorCache;
import com.wolf89.wolf.model.entity.user.UUserEntity;
import com.wolf89.wolf.service.user.LoginService;
import com.wolf89.wolf.service.user.UUserEntityService;
import com.wolf89.wolf.utils.LocalDateUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ValidationException;
import java.time.LocalDateTime;

@Service
public class LoginServiceImpl extends AbstractServiceImpl implements LoginService {

    private static final Logger LOG = LoggerFactory.getLogger(LoginServiceImpl.class);

    @Autowired
    private UUserEntityService uUserEntityService;

    @Autowired
    private LoginErrorCacheRepository loginErrorCacheRepository;

    /**
     * 用户登录.
     *
     * @param form 参数.
     * @return 登录信息.
     */
    @Override
    public ApiOutput<String> loginByName(LoginForm form) {

        LOG.info("用户[{}]登录", form.getName());

        UUserEntity userEntity = uUserEntityService.findByName(form.getName());

        if (userEntity == null) {
            throw new ValidationException("用户名不存在");
        }

        // 锁定时间在当前时间之前，不允许登录.
        if (userEntity.getLock().isBefore(LocalDateTime.now())) {
            throw new ValidationException("用户被锁定");
        }

        // 查询错误缓存.
        LoginErrorCache loginErrorCache = loginErrorCacheRepository.findByUserId(userEntity.getId());

        // 连续输入五次错误，用户锁定三十分钟.
        if (loginErrorCache != null && loginErrorCache.getError() > 5) {

            userEntity.setLock(LocalDateTime.now().plusMinutes(30));
            this.uUserEntityService.save(userEntity);

            throw new ValidationException("连续输入密码五次错误，账号锁定30分钟");

        }

        String password = DigestUtils.md5Hex(form.getPassword() + LocalDateUtil.convertDateToString(userEntity.getInsert_(), LocalDateUtil.yyyyMMddHHmmss));
        // 判断密码是否正确.
        if (!StringUtils.equals(password, userEntity.getPassword())) {

            // 密码错误，记录错误数.
            if (loginErrorCache != null) {

                loginErrorCache.setError(loginErrorCache.getError() + 1);
            } else {

                loginErrorCache = new LoginErrorCache();
                loginErrorCache.setError(1);
                loginErrorCache.setUserId(userEntity.getId());
            }

            LoginErrorCache loginErrorCache_ = this.loginErrorCacheRepository.save(loginErrorCache);

            throw new ValidationException("用户名或者密码错误<br>连续输入五次将锁定30分钟，您还有" + (5 - loginErrorCache_.getError()) + "次机会");
        }

        return ApiOutput.of("登录成功");
    }
}
