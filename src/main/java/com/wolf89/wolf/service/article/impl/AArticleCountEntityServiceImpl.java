package com.wolf89.wolf.service.article.impl;

import com.wolf89.wolf.core.dao.AbstractEntityRepository;
import com.wolf89.wolf.core.service.AbstractEntityServiceImpl;
import com.wolf89.wolf.dao.article.AArticleCountEntityRepository;
import com.wolf89.wolf.model.entity.article.AArticleCountEntity;
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
public class AArticleCountEntityServiceImpl extends AbstractEntityServiceImpl<AArticleCountEntity> {

    private static final Logger LOG = LoggerFactory.getLogger(AArticleCountEntityServiceImpl.class);

    @Autowired
    private AArticleCountEntityRepository aArticleCountEntityRepository;

    @Override
    public AbstractEntityRepository<AArticleCountEntity> getRepository() {
        return aArticleCountEntityRepository;
    }

    @Override
    public Class<AArticleCountEntity> getClazz() {
        return AArticleCountEntity.class;
    }
}
