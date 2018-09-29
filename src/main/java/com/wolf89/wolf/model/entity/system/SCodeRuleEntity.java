package com.wolf89.wolf.model.entity.system;

import com.wolf89.wolf.core.annotation.EntityInfo;
import com.wolf89.wolf.core.entity.AbstractEntity;
import com.wolf89.wolf.core.entity.Type;

import javax.persistence.*;

/**
 * 编码规则.
 *
 * @author gaoweibing
 */
@Entity
@Table(schema = "wsystem", name = "S_CODE_RULE")
@AttributeOverride(name = "id", column = @Column(name = "cr_id", length = 40, updatable = false))
public class SCodeRuleEntity extends AbstractEntity {

    @EntityInfo(name = "前缀", value = "prefix")
    @Column(name = "cr_prefix", length = 5)
    private String prefix;

    @EntityInfo(name = "长度", value = "length")
    @Column(name = "cr_length")
    private int length;

    @EntityInfo(name = "分类", value = "type")
    @AttributeOverrides({
            @AttributeOverride(name = "code", column = @Column(name = "cr_type_code")),
            @AttributeOverride(name = "name", column = @Column(name = "cr_type_name"))
    })
    private Type type;

    @EntityInfo(name = "最短长度", value = "minLength")
    @Column(name = "cr_min_length")
    private int minLength;

    @EntityInfo(name = "最长长度", value = "maxLength")
    @Column(name = "cr_max_length")
    private int maxLength;

    @EntityInfo(name = "开始编号", value = "start")
    @Column(name = "cr_start")
    private int start;

    @EntityInfo(name = "累计数", value = "count")
    @Column(name = "cr_count")
    private int count;

    @EntityInfo(name = "备注", value = "note")
    @Column(name = "cr_note", length = 200)
    private String note;

    /**
     * Gets the value of type.
     *
     * @return the value of type.
     */
    public Type getType() {
        return type;
    }

    /**
     * Sets the type.
     * <p>You can use getType() to get the value of type.</p>
     *
     * @param type type.
     */
    public void setType(Type type) {
        this.type = type;
    }

    /**
     * Gets the value of prefix.
     *
     * @return the value of prefix.
     */
    public String getPrefix() {
        return prefix;
    }

    /**
     * Sets the prefix.
     * <p>You can use getPrefix() to get the value of prefix.</p>
     *
     * @param prefix prefix.
     */
    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    /**
     * Gets the value of length.
     *
     * @return the value of length.
     */
    public int getLength() {
        return length;
    }

    /**
     * Sets the length.
     * <p>You can use getLength() to get the value of length.</p>
     *
     * @param length length.
     */
    public void setLength(int length) {
        this.length = length;
    }

    /**
     * Gets the value of minLength.
     *
     * @return the value of minLength.
     */
    public int getMinLength() {
        return minLength;
    }

    /**
     * Sets the minLength.
     * <p>You can use getMinLength() to get the value of minLength.</p>
     *
     * @param minLength minLength.
     */
    public void setMinLength(int minLength) {
        this.minLength = minLength;
    }

    /**
     * Gets the value of maxLength.
     *
     * @return the value of maxLength.
     */
    public int getMaxLength() {
        return maxLength;
    }

    /**
     * Sets the maxLength.
     * <p>You can use getMaxLength() to get the value of maxLength.</p>
     *
     * @param maxLength maxLength.
     */
    public void setMaxLength(int maxLength) {
        this.maxLength = maxLength;
    }

    /**
     * Gets the value of start.
     *
     * @return the value of start.
     */
    public int getStart() {
        return start;
    }

    /**
     * Sets the start.
     * <p>You can use getStart() to get the value of start.</p>
     *
     * @param start start.
     */
    public void setStart(int start) {
        this.start = start;
    }

    /**
     * Gets the value of count.
     *
     * @return the value of count.
     */
    public int getCount() {
        return count;
    }

    /**
     * Sets the count.
     * <p>You can use getCount() to get the value of count.</p>
     *
     * @param count count.
     */
    public void setCount(int count) {
        this.count = count;
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
