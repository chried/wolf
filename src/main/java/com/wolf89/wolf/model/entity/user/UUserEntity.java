package com.wolf89.wolf.model.entity.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.wolf89.wolf.core.annotation.EntityInfo;
import com.wolf89.wolf.core.entity.AbstractEntity;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * 用户实体类.
 *
 * @author chried
 */
@Entity
@Table(schema = "wuser", name = "U_USER")
@AttributeOverride(
        name = "id", column = @Column(name = "u_id", length = 40)
)
public class UUserEntity extends AbstractEntity {

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

    @Column(name = "u_lock")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @EntityInfo(name = "锁定时间", value = "lock")
    private LocalDateTime lock;

    @Column(name = "u_expire")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @EntityInfo(name = "密码过期时间", value = "expire")
    private LocalDateTime expire;

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
     * Gets the value of lock.
     *
     * @return the value of lock.
     */
    public LocalDateTime getLock() {
        return lock;
    }

    /**
     * Sets the lock.
     * <p>You can use getLock() to get the value of lock.</p>
     *
     * @param lock lock.
     */
    public void setLock(LocalDateTime lock) {
        this.lock = lock;
    }

    /**
     * Gets the value of expire.
     *
     * @return the value of expire.
     */
    public LocalDateTime getExpire() {
        return expire;
    }

    /**
     * Sets the expire.
     * <p>You can use getExpire() to get the value of expire.</p>
     *
     * @param expire expire.
     */
    public void setExpire(LocalDateTime expire) {
        this.expire = expire;
    }
}
