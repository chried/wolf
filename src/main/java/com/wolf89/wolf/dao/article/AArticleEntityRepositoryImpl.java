package com.wolf89.wolf.dao.article;

import com.wolf89.wolf.core.dao.AbstractEntityRepositoryImpl;
import com.wolf89.wolf.model.entity.article.AArticleEntity;

/**
 * dao实现.
 *
 * @author gaoweibing
 */
public class AArticleEntityRepositoryImpl extends AbstractEntityRepositoryImpl<AArticleEntity> {

    /**
     * 主实体类.
     */
    @Override
    protected Class<AArticleEntity> getClazz() {
        return AArticleEntity.class;
    }
}
