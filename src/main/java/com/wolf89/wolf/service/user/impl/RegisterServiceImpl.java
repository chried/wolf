package com.wolf89.wolf.service.user.impl;

import com.wolf89.wolf.core.output.ApiOutput;
import com.wolf89.wolf.core.service.AbstractServiceImpl;
import com.wolf89.wolf.dto.user.RegisterForm;
import com.wolf89.wolf.entity.system.SValidateEntity;
import com.wolf89.wolf.entity.user.UUserEntity;
import com.wolf89.wolf.service.system.SValidateEntityService;
import com.wolf89.wolf.service.user.RegisterService;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    /**
     * 用户注册.
     * <pre>
     *     用户注册顺序：
     *     1、用户名；
     *     2、手机号；
     *     3、邮箱号。
     * </pre>
     *
     * @param form 参数.
     * @return 操作信息.
     */
    @Override
    public ApiOutput<String> registerUser(RegisterForm form) {

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

        if (StringUtils.isNotBlank(form.getUsername())) {

        }

        return null;

    }

    /**
     * 用户名注册.
     *
     * @param form 参数.
     * @return 注册信息.
     */
    private ApiOutput<String> registerUserByUsername(RegisterForm form) {


        return null;
    }


    private UUserEntity createByRegisterForm(RegisterForm form) {

        // 获取当前时间.
        LocalDateTime now = LocalDateTime.now();
        // 定义转换格式.
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");

        UUserEntity userEntity = new UUserEntity();

        userEntity.setInsert_(now);
        userEntity.setUsername(form.getUsername());
        userEntity.setEmail(form.getEmail());
        userEntity.setPhone(form.getPhone());
        // md5加盐.
        userEntity.setPassword(DigestUtils.md5Hex(form.getPassword() + formatter.format(now)));
        userEntity.setLock(now);

        // 密码更新提醒为3个月周期.
        userEntity.setExpire(now.plus(Period.ofMonths(3)));

        return userEntity;

    }
}
