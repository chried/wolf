package com.wolf89.wolf.dao.article;

import com.wolf89.wolf.core.dao.AbstractEntityRepositoryImpl;
import com.wolf89.wolf.model.entity.article.AArticleCommentEntity;

/**
 * dao实现.
 *
 * @author gaoweibing
 */
public class AArticleCommentEntityRepositoryImpl extends AbstractEntityRepositoryImpl<AArticleCommentEntity> {

    /**
     * 主实体类.
     */
    @Override
    protected Class<AArticleCommentEntity> getClazz() {
        return AArticleCommentEntity.class;
    }
}
