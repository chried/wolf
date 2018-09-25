package com.wolf89.wolf.model.entity.article;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 英文翻译相关.
 *
 * @author chried
 */
@Entity
@Table(schema = "warticle", name = "A_E_ARTICLE")
@AttributeOverride(name = "id", column = @Column(name = "ea_id", length = 40, updatable = false))
public class AEArticleEntity extends Article {


}
