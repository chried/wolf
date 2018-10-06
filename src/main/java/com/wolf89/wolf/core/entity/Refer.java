package com.wolf89.wolf.core.entity;

import com.wolf89.wolf.core.annotation.EntityInfo;

import java.io.Serializable;

/**
 * 关联表使用.
 *
 * @author chried
 */
public class Refer implements Serializable {

    /**
     * 主键.
     */
    @EntityInfo(name = "主键", value = "id")
    private String id;

    /**
     * 编号.
     */
    @EntityInfo(name = "编号", value = "code")
    private String code;

    /**
     * 名称.
     */
    @EntityInfo(name = "名称", value = "name")
    private String name;


    public Refer() {

    }

    public Refer(String id, String code, String name) {
        this.code = code;
        this.id = id;
        this.name = name;
    }

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
}
