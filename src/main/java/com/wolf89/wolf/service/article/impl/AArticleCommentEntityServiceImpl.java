package com.wolf89.wolf.service.article.impl;

import com.wolf89.wolf.core.dao.AbstractEntityRepository;
import com.wolf89.wolf.core.service.AbstractEntityServiceImpl;
import com.wolf89.wolf.dao.article.AArticleCommentEntityRepository;
import com.wolf89.wolf.model.entity.article.AArticleCommentEntity;
import com.wolf89.wolf.service.article.AArticleCommentEntityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * service实现.
 *
 * @author gaoweibing
 */
@Service
public class AArticleCommentEntityServiceImpl extends AbstractEntityServiceImpl<AArticleCommentEntity> implements AArticleCommentEntityService {

    private static final Logger LOG = LoggerFactory.getLogger(AArticleCommentEntityServiceImpl.class);

    @Autowired
    private AArticleCommentEntityRepository aArticleCommentEntityRepository;

    @Override
    public AbstractEntityRepository<AArticleCommentEntity> getRepository() {
        return aArticleCommentEntityRepository;
    }

    @Override
    public Class<AArticleCommentEntity> getClazz() {
        return AArticleCommentEntity.class;
    }
}
