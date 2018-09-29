package com.wolf89.wolf.model.entity.article;

import com.wolf89.wolf.core.annotation.EntityInfo;
import com.wolf89.wolf.core.entity.AbstractEntity;
import com.wolf89.wolf.core.entity.Refer;

import javax.persistence.*;

/**
 * 栏目.
 *
 * @author gaoweibing
 */
@Entity
@Table(schema = "warticle", name = "A_COLUMN")
@AttributeOverride(name = "id", column = @Column(name = "c_id", updatable = false, length = 40))
public class AColumnEntity extends AbstractEntity {

    @EntityInfo(name = "名称", value = "name")
    @Column(name = "c_name", length = 50)
    private String name;

    @EntityInfo(name = "编号", value = "code")
    @Column(name = "c_code", length = 20)
    private String code;

    @EntityInfo(name = "作者", value = "author", clazz = "com.wolf89.wolf.core.entity.Refer")
    @AttributeOverrides({
            @AttributeOverride(name = "id", column = @Column(name = "c_author_id", updatable = false, length = 40)),
            @AttributeOverride(name = "code", column = @Column(name = "c_author_code", updatable = false, length = 40)),
            @AttributeOverride(name = "name", column = @Column(name = "c_author_name", updatable = false, length = 40))
    })
    private Refer author;

    /**
     * 1、正常;
     * 3、锁定;
     * 9、违法;
     */
    @EntityInfo(name = "控制状态", value = "control")
    @Column(name = "c_control", columnDefinition = "int2")
    private int control;

    /**
     * logo.
     */
    @EntityInfo(name = "logo", value = "logo")
    @Column(name = "c_logo", length = 200)
    private String logo;

    @EntityInfo(name = "介绍", value = "introduction")
    @Column(name = "c_introduction", length = 200)
    private String introduction;

    @EntityInfo(name = "备注", value = "note")
    @Column(name = "c_note", length = 100)
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
     * Gets the value of author.
     *
     * @return the value of author.
     */
    public Refer getAuthor() {
        return author;
    }

    /**
     * Sets the author.
     * <p>You can use getAuthor() to get the value of author.</p>
     *
     * @param author author.
     */
    public void setAuthor(Refer author) {
        this.author = author;
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

    /**
     * Gets the value of logo.
     *
     * @return the value of logo.
     */
    public String getLogo() {
        return logo;
    }

    /**
     * Sets the logo.
     * <p>You can use getLogo() to get the value of logo.</p>
     *
     * @param logo logo.
     */
    public void setLogo(String logo) {
        this.logo = logo;
    }

    /**
     * Gets the value of introduction.
     *
     * @return the value of introduction.
     */
    public String getIntroduction() {
        return introduction;
    }

    /**
     * Sets the introduction.
     * <p>You can use getIntroduction() to get the value of introduction.</p>
     *
     * @param introduction introduction.
     */
    public void setIntroduction(String introduction) {
        this.introduction = introduction;
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
}
