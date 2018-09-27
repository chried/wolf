package com.wolf89.wolf.model.entity.article;

import com.wolf89.wolf.core.annotation.EntityInfo;
import com.wolf89.wolf.core.entity.AbstractEntity;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 文章统计数.
 *
 * @author chried
 */
@Entity
@Table(schema = "warticle", name = "A_ARTICLE_COUNT")
@AttributeOverride(name = "id", column = @Column(name = "ac_id", length = 40, updatable = false))
public class AArticleCountEntity extends AbstractEntity {

    @EntityInfo(name = "收藏数", value = "collection")
    @Column(name = "ac_collection", columnDefinition = "int4")
    private int collection;

    @EntityInfo(name = "评论数", value = "comment")
    @Column(name = "ac_comment", columnDefinition = "int4")
    private int comment;

    @EntityInfo(name = "分享数", value = "share")
    @Column(name = "ac_share", columnDefinition = "int4")
    private int share;

    @EntityInfo(name = "转载数", value = "reprint")
    @Column(name = "ac_reprint", columnDefinition = "int4")
    private int reprint;

    /**
     * Gets the value of collection.
     *
     * @return the value of collection.
     */
    public int getCollection() {
        return collection;
    }

    /**
     * Sets the collection.
     * <p>You can use getCollection() to get the value of collection.</p>
     *
     * @param collection collection.
     */
    public void setCollection(int collection) {
        this.collection = collection;
    }

    /**
     * Gets the value of comment.
     *
     * @return the value of comment.
     */
    public int getComment() {
        return comment;
    }

    /**
     * Sets the comment.
     * <p>You can use getComment() to get the value of comment.</p>
     *
     * @param comment comment.
     */
    public void setComment(int comment) {
        this.comment = comment;
    }

    /**
     * Gets the value of share.
     *
     * @return the value of share.
     */
    public int getShare() {
        return share;
    }

    /**
     * Sets the share.
     * <p>You can use getShare() to get the value of share.</p>
     *
     * @param share share.
     */
    public void setShare(int share) {
        this.share = share;
    }

    /**
     * Gets the value of reprint.
     *
     * @return the value of reprint.
     */
    public int getReprint() {
        return reprint;
    }

    /**
     * Sets the reprint.
     * <p>You can use getReprint() to get the value of reprint.</p>
     *
     * @param reprint reprint.
     */
    public void setReprint(int reprint) {
        this.reprint = reprint;
    }
}
