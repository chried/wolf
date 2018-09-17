package com.wolf89.wolf.model.entity.system;

import com.wolf89.wolf.core.annotation.EntityInfo;
import com.wolf89.wolf.core.entity.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 验证实体类.
 *
 * @author chried
 */
@Entity
@Table(schema = "wsystem", name = "S_VALIDATE")
public class SValidateEntity extends AbstractEntity {

    @EntityInfo(name = "名称", value = "name", note = "记录名称，例如电话号，邮箱")
    @Column(name = "v_name", length = 50)
    private String name;

    @EntityInfo(name = "类型", value = "type", note = "例如手机(phone)、邮箱(email)")
    @Column(name = "v_type", length = 10)
    private String type;

    @EntityInfo(name = "验证码", value = "code")
    @Column(name = "v_code", length = 10)
    private String code;

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
     * Gets the value of type.
     *
     * @return the value of type.
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the type.
     * <p>You can use getType() to get the value of type.</p>
     *
     * @param type type.
     */
    public void setType(String type) {
        this.type = type;
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
}
