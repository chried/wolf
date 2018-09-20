package com.wolf89.wolf.dto.user;

import com.wolf89.wolf.core.annotation.EntityInfo;
import com.wolf89.wolf.core.entity.Refer;

import java.io.Serializable;
import java.util.List;

/**
 * 登录成功之后返回的结构.
 *
 * @author gaoweibing
 */
public class LoginResult implements Serializable {

    /**
     * 令牌.
     */
    @EntityInfo(name = "令牌", value = "token")
    private String token;

    /**
     * 用户.
     */
    @EntityInfo(name = "用户", value = "user")
    private Refer user;

    /**
     * 角色.
     */
    @EntityInfo(name = "角色", value = "roles")
    private List<Refer> roles;

    /**
     * 跳转地址.
     */
    @EntityInfo(name = "跳转地址", value = "direction")
    private String direction;

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
     * Gets the value of user.
     *
     * @return the value of user.
     */
    public Refer getUser() {
        return user;
    }

    /**
     * Sets the user.
     * <p>You can use getUser() to get the value of user.</p>
     *
     * @param user user.
     */
    public void setUser(Refer user) {
        this.user = user;
    }

    /**
     * Gets the value of roles.
     *
     * @return the value of roles.
     */
    public List<Refer> getRoles() {
        return roles;
    }

    /**
     * Sets the roles.
     * <p>You can use getRoles() to get the value of roles.</p>
     *
     * @param roles roles.
     */
    public void setRoles(List<Refer> roles) {
        this.roles = roles;
    }

    /**
     * Gets the value of direction.
     *
     * @return the value of direction.
     */
    public String getDirection() {
        return direction;
    }

    /**
     * Sets the direction.
     * <p>You can use getDirection() to get the value of direction.</p>
     *
     * @param direction direction.
     */
    public void setDirection(String direction) {
        this.direction = direction;
    }
}
