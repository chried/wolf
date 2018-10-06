package com.wolf89.wolf.dao.article;

import com.wolf89.wolf.core.dao.AbstractEntityRepositoryImpl;
import com.wolf89.wolf.model.entity.article.AEArticleEntity;

/**
 * dao实现.
 *
 * @author chried
 */
public class AEArticleEntityRepositoryImpl extends AbstractEntityRepositoryImpl<AEArticleEntity> {
    
    /**
     * 主实体类.
     */
    @Override
    protected Class<AEArticleEntity> getClazz() {
        return AEArticleEntity.class;
    }
}
