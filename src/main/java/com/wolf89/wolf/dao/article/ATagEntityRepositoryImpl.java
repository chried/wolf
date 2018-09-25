package com.wolf89.wolf.dao.article;

import com.wolf89.wolf.core.dao.AbstractEntityRepositoryImpl;
import com.wolf89.wolf.model.entity.article.ATagEntity;

/**
 * dao实现.
 *
 * @author gaoweibing
 */
public class ATagEntityRepositoryImpl extends AbstractEntityRepositoryImpl<ATagEntity> {

    /**
     * 主实体类.
     */
    @Override
    protected Class<ATagEntity> getClazz() {
        return ATagEntity.class;
    }
}
