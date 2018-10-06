package com.wolf89.wolf.model.entity.article;

import com.wolf89.wolf.core.annotation.EntityInfo;
import com.wolf89.wolf.core.entity.Refer;
import com.wolf89.wolf.core.entity.AbstractClassifyEntity;

import javax.persistence.*;

/**
 * 评论.
 *
 * @author chried
 */
@Entity
@Table(schema = "warticle", name = "A_ARTICLE_COMMENT")
@AttributeOverride(name = "id", column = @Column(name = "ac_id", length = 40, updatable = false))
public class AArticleCommentEntity extends AbstractClassifyEntity {

    @EntityInfo(name = "评论者", value = "user")
    @AttributeOverrides({
            @AttributeOverride(name = "id", column = @Column(name = "ac_user_id", length = 40, updatable = false)),
            @AttributeOverride(name = "code", column = @Column(name = "ac_user_code", length = 50, updatable = false)),
            @AttributeOverride(name = "name", column = @Column(name = "ac_user_name", length = 50, updatable = false))
    })
    @Embedded
    private Refer user_;

    @EntityInfo(name = "关联文章", value = "articleId")
    @Column(name = "ac_articleId", length = 40, updatable = false)
    private String articleId;

    @EntityInfo(name = "点赞数", value = "praise")
    @Column(name = "ac_praise")
    private int praise;

    @EntityInfo(name = "踩数", value = "tread")
    @Column(name = "ac_tread")
    private int tread;

    @EntityInfo(name = "内容", value = "content")
    @Column(name = "ac_content", columnDefinition = "text")
    private String content;

    /**
     * Gets the value of user_.
     *
     * @return the value of user_.
     */
    public Refer getUser_() {
        return user_;
    }

    /**
     * Sets the user_.
     * <p>You can use getUser_() to get the value of user_.</p>
     *
     * @param user_ user_.
     */
    public void setUser_(Refer user_) {
        this.user_ = user_;
    }

    /**
     * Gets the value of articleId.
     *
     * @return the value of articleId.
     */
    public String getArticleId() {
        return articleId;
    }

    /**
     * Sets the articleId.
     * <p>You can use getArticleId() to get the value of articleId.</p>
     *
     * @param articleId articleId.
     */
    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    /**
     * Gets the value of content.
     *
     * @return the value of content.
     */
    public String getContent() {
        return content;
    }

    /**
     * Sets the content.
     * <p>You can use getContent() to get the value of content.</p>
     *
     * @param content content.
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * Gets the value of praise.
     *
     * @return the value of praise.
     */
    public int getPraise() {
        return praise;
    }

    /**
     * Sets the praise.
     * <p>You can use getPraise() to get the value of praise.</p>
     *
     * @param praise praise.
     */
    public void setPraise(int praise) {
        this.praise = praise;
    }

    /**
     * Gets the value of tread.
     *
     * @return the value of tread.
     */
    public int getTread() {
        return tread;
    }

    /**
     * Sets the tread.
     * <p>You can use getTread() to get the value of tread.</p>
     *
     * @param tread tread.
     */
    public void setTread(int tread) {
        this.tread = tread;
    }
}
