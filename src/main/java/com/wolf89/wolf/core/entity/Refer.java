package com.wolf89.wolf.core.entity;

import com.wolf89.wolf.core.annotation.EntityInfo;

import javax.persistence.MappedSuperclass;

/**
 * 关联表使用.
 *
 * @author chried
 */
@MappedSuperclass
public class Refer extends Type {

    @EntityInfo(name = "主键", value = "id")
    private String id;

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
}
