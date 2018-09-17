package com.wolf89.wolf.service.user.impl;

import com.wolf89.wolf.core.entity.EntityParameter;
import com.wolf89.wolf.core.output.ApiOutput;
import com.wolf89.wolf.core.service.AbstractServiceImpl;
import com.wolf89.wolf.dto.user.RegisterForm;
import com.wolf89.wolf.model.entity.system.SValidateEntity;
import com.wolf89.wolf.model.entity.user.URegisterEntity;
import com.wolf89.wolf.model.entity.user.UUserDetailEntity;
import com.wolf89.wolf.model.entity.user.UUserEntity;
import com.wolf89.wolf.service.system.SValidateEntityService;
import com.wolf89.wolf.service.user.RegisterService;
import com.wolf89.wolf.service.user.URegisterEntityService;
import com.wolf89.wolf.service.user.UUserDetailEntityService;
import com.wolf89.wolf.service.user.UUserEntityService;
import com.wolf89.wolf.utils.LocalDateUtil;
import com.wolf89.wolf.utils.SerialUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ValidationException;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;

/**
 * 注册实现.
 *
 * @author chried
 */
@Service
public class RegisterServiceImpl extends AbstractServiceImpl implements RegisterService {

    private static final Logger LOG = LoggerFactory.getLogger(RegisterServiceImpl.class);

    @Autowired
    private SValidateEntityService sValidateEntityService;

    @Autowired
    private UUserEntityService uUserEntityService;

    @Autowired
    private UUserDetailEntityService uUserDetailEntityService;

    @Autowired
    private URegisterEntityService uRegisterEntityService;

    /**
     * 用户注册.
     * <pre>
     *    将用户表，注册表，用户详情表主键id相同.
     * </pre>
     *
     * @param form 参数.
     * @return 操作信息.
     */
    @Override
    public ApiOutput<String> registerUser(RegisterForm form) {

        LOG.info("用户注册");

        if (form == null) {
            throw new ValidationException("参数[registerForm]不能为空");
        }

        /**
         * ***************验证验证码是否合法**************
         */

        if (form.getValidate() == null || StringUtils.isBlank(form.getValidate().getCode())) {
            throw new ValidationException("验证码不能为空");
        }

        SValidateEntity sValidateEntity = this.sValidateEntityService.get_(form.getValidate().getId());

        if (sValidateEntity == null) {
            throw new ValidationException("验证失败，请重新生成");
        }

        if (!StringUtils.equals(form.getValidate().getCode(), sValidateEntity.getCode())) {
            throw new ValidationException("验证码错误，请重新输入");
        }

        /**
         * ***************注册开始**************
         */

        // 创建用户信息.
        UUserEntity userEntity = this.createByRegisterForm(form);

        // 保存用户信息.
        UUserEntity userEntity_ = uUserEntityService.save_(userEntity);

        // 创建注册表.
        URegisterEntity uRegisterEntity = new URegisterEntity();

        BeanUtils.copyProperties(form, uRegisterEntity, "password");

        LocalDateTime now = LocalDateTime.now();

        uRegisterEntity.setPassword(userEntity_.getPassword());
        uRegisterEntity.setId(userEntity_.getId());
        uRegisterEntity.setInsert_(now);
        uRegisterEntity.setUpdate_(now);
        uRegisterEntity.setStatus_(EntityParameter.ACTIVE);

        this.uRegisterEntityService.save(uRegisterEntity);

        // 创建用户详情.
        UUserDetailEntity uUserDetailEntity = new UUserDetailEntity();

        uUserDetailEntity.setId(userEntity_.getId());
        uUserDetailEntity.setNickname("新用户-" + SerialUtil.generator(8, SerialUtil.CHARS_ALL));
        uUserDetailEntity.setInsert_(now);
        uUserDetailEntity.setUpdate_(now);
        uUserDetailEntity.setStatus_(EntityParameter.ACTIVE);

        this.uUserDetailEntityService.save(uUserDetailEntity);

        return ApiOutput.of("注册成功");

    }

    /**
     * 创建用户.
     *
     * @param form 注册参数.
     * @return 用户信息.
     */
    private UUserEntity createByRegisterForm(RegisterForm form) {

        // 获取当前时间.
        LocalDateTime now = LocalDateTime.now();

        UUserEntity userEntity = new UUserEntity();
        userEntity.setInsert_(now);
        userEntity.setUsername(form.getUsername());
        userEntity.setEmail(form.getEmail());
        userEntity.setPhone(form.getPhone());
        // md5加盐.
        userEntity.setPassword(DigestUtils.md5Hex(form.getPassword() + LocalDateUtil.convertDateToString(now, LocalDateUtil.yyyyMMddHHmmss)));
        userEntity.setLock(now);

        // 密码更新提醒为3个月周期.
        userEntity.setExpire(now.plus(Period.ofMonths(3)));

        return userEntity;

    }
}
