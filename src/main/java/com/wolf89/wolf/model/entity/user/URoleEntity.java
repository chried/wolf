package com.wolf89.wolf.model.entity.user;

import com.wolf89.wolf.core.annotation.EntityInfo;
import com.wolf89.wolf.core.entity.AbstractEntity;
import com.wolf89.wolf.core.entity.Refer;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 角色实体类.
 *
 * @author gaoweibing
 */
@Entity
@Table(schema = "wuser", name = "U_ROLE")
@AttributeOverride(
        name = "id", column = @Column(name = "r_id", length = 40)
)
public class URoleEntity extends AbstractEntity {

    /**
     * 名称.
     */
    @EntityInfo(name = "名称", value = "name")
    @Column(name = "r_name", length = 50)
    private String name;

    /**
     * 标志.
     */
    @EntityInfo(name = "标志", value = "sign")
    @Column(name = "r_sign", length = 40)
    private String sign;

    /**
     * 备注.
     */
    @EntityInfo(name = "备注", value = "note")
    @Column(name = "r_note", length = 100)
    private String note;

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

    /**
     * Gets the value of note.
     *
     * @return the value of note.
     */
    public String getNote() {
        return note;
    }

    /**
     * Sets the note.
     * <p>You can use getNote() to get the value of note.</p>
     *
     * @param note note.
     */
    public void setNote(String note) {
        this.note = note;
    }

    /**
     * 转换.
     *
     * @return
     */
    public Refer toRefer() {

        return new Refer(this.getId(), null, this.getName());

    }
}
