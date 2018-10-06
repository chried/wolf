package com.wolf89.wolf.core.entity;

import com.wolf89.wolf.core.annotation.EntityInfo;

import java.io.Serializable;

/**
 * 令牌.
 */
public final class Token implements Serializable {

    /**
     * 设置token.
     */
    public static String TOKEN = "w-token";

    @EntityInfo(name = "token", value = "token")
    private String token;

    @EntityInfo(name = "用户", value = "user")
    private Refer user;

    @EntityInfo(name = "昵称", value = "nickname")
    private String nickname;

    @EntityInfo(name = "头像", value = "portrait")
    private String portrait;

    @EntityInfo(name = "签名", value = "signature")
    private String signature;

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
     * Gets the value of nickname.
     *
     * @return the value of nickname.
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * Sets the nickname.
     * <p>You can use getNickname() to get the value of nickname.</p>
     *
     * @param nickname nickname.
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * Gets the value of portrait.
     *
     * @return the value of portrait.
     */
    public String getPortrait() {
        return portrait;
    }

    /**
     * Sets the portrait.
     * <p>You can use getPortrait() to get the value of portrait.</p>
     *
     * @param portrait portrait.
     */
    public void setPortrait(String portrait) {
        this.portrait = portrait;
    }

    /**
     * Gets the value of signature.
     *
     * @return the value of signature.
     */
    public String getSignature() {
        return signature;
    }

    /**
     * Sets the signature.
     * <p>You can use getSignature() to get the value of signature.</p>
     *
     * @param signature signature.
     */
    public void setSignature(String signature) {
        this.signature = signature;
    }
}
