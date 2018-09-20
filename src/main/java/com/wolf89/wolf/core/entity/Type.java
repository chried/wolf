package com.wolf89.wolf.core.entity;

import com.wolf89.wolf.core.annotation.EntityInfo;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * 关联类型.
 *
 * @author chried
 */
@MappedSuperclass
public class Type implements Serializable {

    @EntityInfo(name = "编码", value = "code")
    private String code;

    @EntityInfo(name = "名称", value = "name")
    private String name;

    public Type() {

    }

    public Type(String code, String name) {

        this.code = code;
        this.name = name;
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
