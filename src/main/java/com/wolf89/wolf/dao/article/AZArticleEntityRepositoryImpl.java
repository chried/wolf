package com.wolf89.wolf.dao.article;

import com.wolf89.wolf.core.dao.AbstractEntityRepositoryImpl;
import com.wolf89.wolf.model.entity.article.AZArticleEntity;

/**
 * dao实现.
 *
 * @author gaoweibing
 */
public class AZArticleEntityRepositoryImpl extends AbstractEntityRepositoryImpl<AZArticleEntity> {

    /**
     * 主实体类.
     */
    @Override
    protected Class<AZArticleEntity> getClazz() {
        return AZArticleEntity.class;
    }
}
