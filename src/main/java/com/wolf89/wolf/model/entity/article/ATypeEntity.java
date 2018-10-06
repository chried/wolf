package com.wolf89.wolf.model.entity.article;

import com.wolf89.wolf.core.entity.AbstractClassifyEntity;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 分类.
 */
@Entity
@Table(schema = "warticle", name = "A_TYPE")
@AttributeOverride(name = "id", column = @Column(name = "t_id", length = 40, updatable = false))
public class ATypeEntity extends AbstractClassifyEntity {

}
