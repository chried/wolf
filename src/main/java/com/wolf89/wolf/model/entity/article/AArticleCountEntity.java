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

    @EntityInfo(name = "文章", value = "articleId")
    private String articleId;

    @EntityInfo(name = "收藏数", value = "collection")
    private int collection;

    @EntityInfo(name = "评论数", value = "comment")
    private int comment;

    @EntityInfo(name = "分享数", value = "share")
    private int share;

    @EntityInfo(name = "转载数", value = "reprint")
    private int reprint;

}
