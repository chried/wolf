package com.wolf89.wolf.dao.article;

import com.wolf89.wolf.core.dao.AbstractEntityRepositoryImpl;
import com.wolf89.wolf.model.entity.article.AArticleCountEntity;

/**
 * dao实现.
 *
 * @author gaoweibing
 */
public class AArticleCountEntityRepositoryImpl extends AbstractEntityRepositoryImpl<AArticleCountEntity> {

    /**
     * 主实体类.
     */
    @Override
    protected Class<AArticleCountEntity> getClazz() {
        return AArticleCountEntity.class;
    }
}
