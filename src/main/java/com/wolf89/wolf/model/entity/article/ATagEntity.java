package com.wolf89.wolf.model.entity.article;

import com.wolf89.wolf.core.annotation.EntityInfo;
import com.wolf89.wolf.core.entity.AbstractEntity;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 标签管理.
 */
@Entity
@Table(schema = "warticle", name = "A_TAG")
@AttributeOverride(name = "id", column = @Column(name = "t_id", length = 40))
public class ATagEntity extends AbstractEntity {

    /**
     * 标签名称.
     */
    @EntityInfo(name = "标签名称", value = "name")
    @Column(name = "t_name", length = 20)
    private String name;

    /**
     * 热度.
     */
    @Column(name = "t_hot")
    @EntityInfo(name = "热度", value = "hot")
    private int hot;

    /**
     * 备注.
     */
    @EntityInfo(name = "备注", value = "note")
    @Column(name = "t_note", length = 100)
    private String note;

    /**
     * 1、正常;3、冻结(不影响文章访问);9、作废(由于政策之类，相关文章全部无法访问);
     */
    @EntityInfo(name = "状态", value = "control")
    private int control;

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
     * Gets the value of hot.
     *
     * @return the value of hot.
     */
    public int getHot() {
        return hot;
    }

    /**
     * Sets the hot.
     * <p>You can use getHot() to get the value of hot.</p>
     *
     * @param hot hot.
     */
    public void setHot(int hot) {
        this.hot = hot;
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
     * Gets the value of control.
     *
     * @return the value of control.
     */
    public int getControl() {
        return control;
    }

    /**
     * Sets the control.
     * <p>You can use getControl() to get the value of control.</p>
     *
     * @param control control.
     */
    public void setControl(int control) {
        this.control = control;
    }
}
