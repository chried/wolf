package com.wolf89.wolf.core.entity;

import com.wolf89.wolf.core.annotation.EntityInfo;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * 冗余id,value值.
 *
 * @author gaoweibing
 */
@MappedSuperclass
public class Value implements Serializable {

    /**
     * id.
     */
    @EntityInfo(name = "主键", value = "id")
    private String id;

    /**
     * 值.
     */
    @EntityInfo(name = "值", value = "value")
    private String value;

    /**
     * 默认构造器.
     */
    public Value() {

    }

    /**
     * 默认构造器.
     *
     * @param id    主键.
     * @param value 值.
     */
    public Value(String id, String value) {

        this.id = id;
        this.value = value;
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
     * Gets the value of value.
     *
     * @return the value of value.
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets the value.
     * <p>You can use getValue() to get the value of value.</p>
     *
     * @param value value.
     */
    public void setValue(String value) {
        this.value = value;
    }
}
