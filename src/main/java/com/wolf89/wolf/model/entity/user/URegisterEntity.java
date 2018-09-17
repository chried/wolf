package com.wolf89.wolf.model.entity.user;

import com.wolf89.wolf.core.annotation.EntityInfo;
import com.wolf89.wolf.core.entity.AbstractEntity;
import com.wolf89.wolf.core.entity.Refer;

import javax.persistence.*;

/**
 * 注册表.
 *
 * @author gaoweibing
 */
@Entity
@Table(schema = "wuser", name = "U_REGISTER")
@AttributeOverride(
        name = "id", column = @Column(name = "r_id", length = 40)
)
public class URegisterEntity extends AbstractEntity {

    @Column(name = "u_username", length = 100)
    @EntityInfo(name = "用户名", value = "username")
    private String username;

    @Column(name = "u_password", length = 100)
    @EntityInfo(name = "密码", value = "password")
    private String password;

    @Column(name = "u_email", length = 100)
    @EntityInfo(name = "邮箱", value = "email")
    private String email;

    @Column(name = "u_phone", length = 20)
    @EntityInfo(name = "电话", value = "phone")
    private String phone;

    @AttributeOverrides({
            @AttributeOverride(
                    name = "id", column = @Column(name = "r_validate_id", length = 40)
            ),
            @AttributeOverride(
                    name = "code", column = @Column(name = "r_validate_code", length = 50)
            ),
            @AttributeOverride(
                    name = "name", column = @Column(name = "r_validate_name", length = 50)
            )
    })
    @Embedded
    @EntityInfo(name = "验证", value = "validate")
    private Refer validate;


    /**
     * Gets the value of username.
     *
     * @return the value of username.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username.
     * <p>You can use getUsername() to get the value of username.</p>
     *
     * @param username username.
     */
    public void setUsername(String username) {
        this.username = username;
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
     * Gets the value of email.
     *
     * @return the value of email.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email.
     * <p>You can use getEmail() to get the value of email.</p>
     *
     * @param email email.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the value of phone.
     *
     * @return the value of phone.
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Sets the phone.
     * <p>You can use getPhone() to get the value of phone.</p>
     *
     * @param phone phone.
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Gets the value of validate.
     *
     * @return the value of validate.
     */
    public Refer getValidate() {
        return validate;
    }

    /**
     * Sets the validate.
     * <p>You can use getValidate() to get the value of validate.</p>
     *
     * @param validate validate.
     */
    public void setValidate(Refer validate) {
        this.validate = validate;
    }
}
