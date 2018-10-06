package com.wolf89.wolf.service.user.impl;

import com.wolf89.wolf.core.entity.Refer;
import com.wolf89.wolf.core.entity.Token;
import com.wolf89.wolf.core.output.ApiOutput;
import com.wolf89.wolf.core.service.AbstractServiceImpl;
import com.wolf89.wolf.dto.user.LoginForm;
import com.wolf89.wolf.dto.user.LoginResult;
import com.wolf89.wolf.model.entity.system.SLoginErrorEntity;
import com.wolf89.wolf.model.entity.user.URoleEntity;
import com.wolf89.wolf.model.entity.user.UUserDetailEntity;
import com.wolf89.wolf.model.entity.user.UUserEntity;
import com.wolf89.wolf.service.system.SLoginErrorEntityService;
import com.wolf89.wolf.service.user.*;
import com.wolf89.wolf.utils.LocalDateUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ValidationException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class LoginServiceImpl extends AbstractServiceImpl implements LoginService {

    private static final Logger LOG = LoggerFactory.getLogger(LoginServiceImpl.class);

    @Autowired
    private UUserEntityService uUserEntityService;

    @Autowired
    private SLoginErrorEntityService sLoginErrorEntityService;

    @Autowired
    private URoleEntityService uRoleEntityService;

    @Autowired
    private UUserRoleEntityService uUserRoleEntityService;

    @Autowired
    private UUserDetailEntityService uUserDetailEntityService;

    /**
     * 用户登录.
     *
     * @param form 参数.
     * @return 登录信息.
     */
    @Override
    public ApiOutput<LoginResult> loginByName(LoginForm form) {

        LOG.info("用户[{}]登录", form.getName());

        UUserEntity userEntity = uUserEntityService.findByName(form.getName());

        if (userEntity == null) {
            throw new ValidationException("用户名不存在");
        }

        // 锁定时间在当前时间之前，不允许登录.
        if (userEntity.getLock().isAfter(LocalDateTime.now())) {
            throw new ValidationException("用户被锁定");
        }

        String password = DigestUtils.md5Hex(form.getPassword() + LocalDateUtil.convertDateToString(userEntity.getInsert_(), LocalDateUtil.yyyyMMddHHmmss));
        // 判断密码是否正确.
        if (!StringUtils.equals(password, userEntity.getPassword())) {

            // 查询错误缓存.
            SLoginErrorEntity sLoginErrorEntity = sLoginErrorEntityService.findByUserId(userEntity.getId());

            // 密码错误，记录错误数.
            if (sLoginErrorEntity != null) {

                sLoginErrorEntity.setError(sLoginErrorEntity.getError() + 1);
            } else {

                sLoginErrorEntity = new SLoginErrorEntity();
                sLoginErrorEntity.setError(1);
                sLoginErrorEntity.setUserId(userEntity.getId());
            }

            SLoginErrorEntity sLoginErrorEntity_ = this.sLoginErrorEntityService.save_(sLoginErrorEntity);

            if (sLoginErrorEntity_.getError() == 1) {
                throw new ValidationException("用户名或者密码错误<br>连续输入五次将锁定30分钟，您还有" + (5 - sLoginErrorEntity_.getError()) + "次机会");
            } else if (sLoginErrorEntity_.getError() == 5) {

                userEntity.setLock(LocalDateTime.now().plusMinutes(30));
                this.uUserEntityService.save(userEntity);

                throw new ValidationException("连续输入密码五次错误，账号锁定30分钟");

            } else {
                throw new ValidationException("用户名或者密码错误<br>您还有" + (5 - sLoginErrorEntity_.getError()) + "次机会");
            }

        }

        // 登录成功之后删除错误信息.
        this.sLoginErrorEntityService.deleteByUserId(userEntity.getId());

        // 查询详情.
        UUserDetailEntity uUserDetailEntity = this.uUserDetailEntityService.get_(userEntity.getId());

        Refer userRefer = new Refer();

        if (uUserDetailEntity != null) {
            userRefer.setName(uUserDetailEntity.getNickname());
        }

        LoginResult loginResult = new LoginResult();

        // 设置token.
        loginResult.setToken(UUID.randomUUID().toString());

        userRefer.setId(userEntity.getId());
        userRefer.setCode(userEntity.getCode());

        loginResult.setUser(userRefer);
        loginResult.setNickname(uUserDetailEntity.getNickname());
        loginResult.setPortrait(uUserDetailEntity.getPortrait());
        loginResult.setSignature(uUserDetailEntity.getSignature());

        // 获取角色信息.
        List<URoleEntity> uRoleEntityList = this.uRoleEntityService.queryByUserId_(userEntity.getId());

        List<Refer> roleRefers = new ArrayList<>();

        for (URoleEntity uRoleEntity : uRoleEntityList) {

            roleRefers.add(uRoleEntity.toRefer());
        }

        loginResult.setRoles(roleRefers);

        return ApiOutput.of(loginResult);
    }

}
