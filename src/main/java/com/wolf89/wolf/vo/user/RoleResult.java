package com.wolf89.wolf.vo.user;

import java.io.Serializable;

/**
 * 角色返回.
 */
public class RoleResult implements Serializable {

    /**
     * 主键id.
     */
    private String id;

    /**
     * 名称.
     */
    private String name;

    /**
     * 标志.
     */
    private String sign;

    /**
     * Gets the value of id.
     *
     * @return the value of id.
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the id.
     * <p>You can use getId() to get the value of id.</p>
     *
     * @param id id.
     */
    public void setId(String id) {
        this.id = id;
    }

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
     * Gets the value of sign.
     *
     * @return the value of sign.
     */
    public String getSign() {
        return sign;
    }

    /**
     * Sets the sign.
     * <p>You can use getSign() to get the value of sign.</p>
     *
     * @param sign sign.
     */
    public void setSign(String sign) {
        this.sign = sign;
    }
}
