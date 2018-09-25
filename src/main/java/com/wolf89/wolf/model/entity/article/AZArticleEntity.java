package com.wolf89.wolf.model.entity.article;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 转载文章.
 *
 * @author chried
 */
@Entity
@Table(schema = "warticle", name = "A_Z_ARTICLE")
@AttributeOverride(name = "id", column = @Column(name = "ez_id", length = 40, updatable = false))
public class AZArticleEntity extends Article {
}
