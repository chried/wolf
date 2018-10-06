package com.wolf89.wolf.model.entity.system;

import com.wolf89.wolf.core.entity.AbstractClassifyEntity;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 定义数据字段.
 *
 * @author gaoweibing
 */
@Entity
@Table(schema = "wsystem", name = "S_CLASSIFY")
@AttributeOverride(name = "id", column = @Column(name = "c_id", length = 40, updatable = false))
public class SClassifyEntity extends AbstractClassifyEntity {
}
