package com.wolf89.wolf.model.entity.article;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.wolf89.wolf.core.annotation.EntityInfo;
import com.wolf89.wolf.core.entity.AbstractEntity;
import com.wolf89.wolf.core.entity.Type;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * 将英文翻译评论转成从表.
 *
 * @author chried
 */
@Entity
@Table(schema = "warticle", name = "A_E_ARTICLE_COMMENT")
@AttributeOverride(name = "id", column = @Column(name = "eac_id", length = 40, updatable = false))
public class AEArticleCommentEntity extends AbstractEntity {

    @EntityInfo(name = "作者", value = "author", note = "指评论者")
    @Column(name = "eac_author", length = 50)
    private String author;

    @EntityInfo(name = "地址", value = "address", note = "评论者地址")
    @Column(name = "eac_address", length = 100)
    private String address;

    @EntityInfo(name = "简介", value = "profile", note = "网站上可能有作者的简介")
    @Column(name = "eac_profile", length = 100)
    private String profile;

    @EntityInfo(name = "回复时间", value = "date", note = "评论时间")
    @Column(name = "eac_date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime date;

    @EntityInfo(name = "原文", value = "original", note = "原文，可以是法文，英文")
    @Column(name = "eac_original", columnDefinition = "text")
    private String original;

    @EntityInfo(name = "原文类型", value = "originalType", clazz = "com.wolf89.wolf.core.entity.Type", note = "英文、法文、德文")
    @Column(name = "eac_original_type", columnDefinition = "text")
    private Type originalType;

    @EntityInfo(name = "中文", value = "chinese_", note = "翻译之后成中文")
    @Column(name = "eac_chinese", columnDefinition = "text")
    private String chinese_;

    /**
     * Gets the value of author.
     *
     * @return the value of author.
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Sets the author.
     * <p>You can use getAuthor() to get the value of author.</p>
     *
     * @param author author.
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Gets the value of address.
     *
     * @return the value of address.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the address.
     * <p>You can use getAddress() to get the value of address.</p>
     *
     * @param address address.
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Gets the value of profile.
     *
     * @return the value of profile.
     */
    public String getProfile() {
        return profile;
    }

    /**
     * Sets the profile.
     * <p>You can use getProfile() to get the value of profile.</p>
     *
     * @param profile profile.
     */
    public void setProfile(String profile) {
        this.profile = profile;
    }

    /**
     * Gets the value of date.
     *
     * @return the value of date.
     */
    public LocalDateTime getDate() {
        return date;
    }

    /**
     * Sets the date.
     * <p>You can use getDate() to get the value of date.</p>
     *
     * @param date date.
     */
    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    /**
     * Gets the value of original.
     *
     * @return the value of original.
     */
    public String getOriginal() {
        return original;
    }

    /**
     * Sets the original.
     * <p>You can use getOriginal() to get the value of original.</p>
     *
     * @param original original.
     */
    public void setOriginal(String original) {
        this.original = original;
    }

    /**
     * Gets the value of originalType.
     *
     * @return the value of originalType.
     */
    public Type getOriginalType() {
        return originalType;
    }

    /**
     * Sets the originalType.
     * <p>You can use getOriginalType() to get the value of originalType.</p>
     *
     * @param originalType originalType.
     */
    public void setOriginalType(Type originalType) {
        this.originalType = originalType;
    }

    /**
     * Gets the value of chinese_.
     *
     * @return the value of chinese_.
     */
    public String getChinese_() {
        return chinese_;
    }

    /**
     * Sets the chinese_.
     * <p>You can use getChinese_() to get the value of chinese_.</p>
     *
     * @param chinese_ chinese_.
     */
    public void setChinese_(String chinese_) {
        this.chinese_ = chinese_;
    }
}
