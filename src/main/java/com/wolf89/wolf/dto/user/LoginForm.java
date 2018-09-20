package com.wolf89.wolf.dto.user;

import com.wolf89.wolf.core.annotation.EntityInfo;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 登录.
 *
 * @author gaoweibing
 */
public class LoginForm implements Serializable {

    /**
     * 用户名.
     */
    @EntityInfo(name = "用户名", value = "name", note = "可以是电话、邮箱、用户名")
    @NotNull(message = "用户名必填")
    private String name;

    /**
     * 密码.
     */
    @EntityInfo(name = "密码", value = "password")
    @NotNull(message = "密码必填")
    private String password;

    /**
     * 编码.
     */
    @EntityInfo(name = "编码", value = "code")
    @NotNull(message = "验证码必填")
    private String code;

    /**
     * 类型.
     */
    @EntityInfo(name = "类型", value = "type", note = "例如，网页(site)、ios,android")
    private String type;

    /**
     * Gets the value of name.
     *
     * @return the value of name.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name.
     * <p>You can use getName() to get the value of name.</p>
     *
     * @param name name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the value of password.
     *
     * @return the value of password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password.
     * <p>You can use getPassword() to get the value of password.</p>
     *
     * @param password password.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets the value of code.
     *
     * @return the value of code.
     */
    public String getCode() {
        return code;
    }

    /**
     * Sets the code.
     * <p>You can use getCode() to get the value of code.</p>
     *
     * @param code code.
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Gets the value of type.
     *
     * @return the value of type.
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the type.
     * <p>You can use getType() to get the value of type.</p>
     *
     * @param type type.
     */
    public void setType(String type) {
        this.type = type;
    }
}
