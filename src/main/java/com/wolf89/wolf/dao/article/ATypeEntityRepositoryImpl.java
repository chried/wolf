package com.wolf89.wolf.dao.article;

import com.wolf89.wolf.core.dao.AbstractClassifyEntityRepositoryImpl;
import com.wolf89.wolf.model.entity.article.ATypeEntity;

/**
 * dao实现.
 *
 * @author chried
 */
public class ATypeEntityRepositoryImpl extends AbstractClassifyEntityRepositoryImpl<ATypeEntity> {

    /**
     * 主实体类.
     */
    @Override
    protected Class<ATypeEntity> getClazz() {
        return ATypeEntity.class;
    }
}
