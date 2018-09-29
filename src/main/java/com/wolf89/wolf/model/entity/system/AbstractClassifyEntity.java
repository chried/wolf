package com.wolf89.wolf.model.entity.system;

import com.wolf89.wolf.core.annotation.EntityInfo;
import com.wolf89.wolf.core.entity.AbstractEntity;
import com.wolf89.wolf.core.entity.Refer;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Size;

/**
 * 定义分类父级.
 *
 * @author gaoweibing
 */
@MappedSuperclass
public abstract class AbstractClassifyEntity extends AbstractEntity {

    /**
     * 代码.
     */
    @Size(max = 30)
    @EntityInfo(name = "代码", value = "code")
    @Column(name = "c_code", nullable = false, length = 50)
    protected String code;

    /**
     * 上级代码.
     */
    @Size(max = 30)
    @EntityInfo(name = "上级代码", value = "lead")
    @Column(name = "c_lead", nullable = false, length = 50)
    protected String lead;

    /**
     * 类型名字.
     */
    @Size(max = 70)
    @EntityInfo(name = "名称", value = "name")
    @Column(name = "c_name", nullable = false, length = 100)
    protected String name;

    /**
     * 是否可见.
     */
    @Column(name = "c_visible")
    @EntityInfo(name = "是否可见", value = "visible")
    protected boolean visible;

    /**
     * 排序位置.
     */
    @EntityInfo(name = "排序", value = "position")
    @Column(name = "c_position")
    protected int position;

    /**
     * 备注.
     */
    @Column(name = "c_note", length = 100)
    @EntityInfo(name = "备注", value = "note")
    protected String note;

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
     * Gets the value of lead.
     *
     * @return the value of lead.
     */
    public String getLead() {
        return lead;
    }

    /**
     * Sets the lead.
     * <p>You can use getLead() to get the value of lead.</p>
     *
     * @param lead lead.
     */
    public void setLead(String lead) {
        this.lead = lead;
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
     * Gets the value of visible.
     *
     * @return the value of visible.
     */
    public boolean isVisible() {
        return visible;
    }

    /**
     * Sets the visible.
     * <p>You can use getVisible() to get the value of visible.</p>
     *
     * @param visible visible.
     */
    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    /**
     * Gets the value of position.
     *
     * @return the value of position.
     */
    public int getPosition() {
        return position;
    }

    /**
     * Sets the position.
     * <p>You can use getPosition() to get the value of position.</p>
     *
     * @param position position.
     */
    public void setPosition(int position) {
        this.position = position;
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
     * @return refer.
     */
    public Refer toRefer() {

        return new Refer(this.getId(), this.getCode(), this.getName());
    }
}
