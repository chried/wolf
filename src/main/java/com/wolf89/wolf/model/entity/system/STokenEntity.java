package com.wolf89.wolf.model.entity.system;

import com.wolf89.wolf.core.annotation.EntityInfo;
import com.wolf89.wolf.core.entity.AbstractEntity;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * 存储活动token.
 *
 * @author gaoweibing
 */
@Entity
@Table(schema = "wsystem", name = "S_TOKEN")
@AttributeOverride(
        name = "id", column = @Column(name = "t_id", length = 40)
)
public class STokenEntity extends AbstractEntity {

    /**
     * 登录类型.
     */
    @EntityInfo(name = "登录类型", value = "login", note = "例如：android,pc,ios")
    @Column(name = "t_login", length = 20)
    private String login;

    /**
     * 用户id.
     */
    @EntityInfo(name = "用户id", value = "userId")
    @Column(name = "t_userId", length = 40)
    private String userId;

    /**
     * 令牌.
     */
    @EntityInfo(name = "令牌", value = "token")
    @Column(name = "t_token", length = 40)
    private String token;

    /**
     * 过期时间.
     */
    @EntityInfo(name = "过期时间", value = "expire")
    @Column(name = "t_expire")
    private LocalDateTime expire;

    /**
     * Gets the value of login.
     *
     * @return the value of login.
     */
    public String getLogin() {
        return login;
    }

    /**
     * Sets the login.
     * <p>You can use getLogin() to get the value of login.</p>
     *
     * @param login login.
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * Gets the value of userId.
     *
     * @return the value of userId.
     */
    public String getUserId() {
        return userId;
    }

    /**
     * Sets the userId.
     * <p>You can use getUserId() to get the value of userId.</p>
     *
     * @param userId userId.
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * Gets the value of token.
     *
     * @return the value of token.
     */
    public String getToken() {
        return token;
    }

    /**
     * Sets the token.
     * <p>You can use getToken() to get the value of token.</p>
     *
     * @param token token.
     */
    public void setToken(String token) {
        this.token = token;
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
