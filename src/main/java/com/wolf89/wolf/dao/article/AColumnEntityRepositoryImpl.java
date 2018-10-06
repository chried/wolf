package com.wolf89.wolf.dao.article;

import com.wolf89.wolf.core.dao.AbstractEntityRepositoryImpl;
import com.wolf89.wolf.model.entity.article.AColumnEntity;

/**
 * dao实现.
 *
 * @author chried
 */
public class AColumnEntityRepositoryImpl extends AbstractEntityRepositoryImpl<AColumnEntity> {

    /**
     * 主实体类.
     */
    @Override
    protected Class<AColumnEntity> getClazz() {
        return AColumnEntity.class;
    }
}
