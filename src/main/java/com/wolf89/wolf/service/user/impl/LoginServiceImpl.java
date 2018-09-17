package com.wolf89.wolf.service.user.impl;

import com.wolf89.wolf.core.output.ApiOutput;
import com.wolf89.wolf.core.service.AbstractServiceImpl;
import com.wolf89.wolf.dto.user.LoginForm;
import com.wolf89.wolf.model.entity.user.UUserEntity;
import com.wolf89.wolf.service.system.LoginErrorCacheService;
import com.wolf89.wolf.service.user.LoginService;
import com.wolf89.wolf.service.user.UUserEntityService;
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
    private LoginErrorCacheService loginErrorCacheService;

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
            throw new ValidationException("用户名或者密码错误");
        }

        // 锁定时间在当前时间之前，不允许登录.
        if (userEntity.getLock().isBefore(LocalDateTime.now())) {
            throw new ValidationException("用户被锁定");
        }

        // 判断密码是否正确.
        if (!StringUtils.equals(DigestUtils.md5Hex(form.getPassword()), userEntity.getPassword())) {
            throw new ValidationException("用户名或者密码错误");
        }

        return ApiOutput.of("登录成功");
    }
}
