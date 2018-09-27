package com.wolf89.wolf.service.article.impl;

import com.wolf89.wolf.core.dao.AbstractEntityRepository;
import com.wolf89.wolf.core.service.AbstractEntityServiceImpl;
import com.wolf89.wolf.dao.article.AArticleEntityRepository;
import com.wolf89.wolf.model.entity.article.AArticleEntity;
import com.wolf89.wolf.service.article.AArticleEntityService;
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
public class AArticleEntityServiceImpl extends AbstractEntityServiceImpl<AArticleEntity> implements AArticleEntityService {

    private static final Logger LOG = LoggerFactory.getLogger(AArticleEntityServiceImpl.class);

    @Autowired
    private AArticleEntityRepository aArticleEntityRepository;

    @Override
    public AbstractEntityRepository<AArticleEntity> getRepository() {
        return aArticleEntityRepository;
    }

    @Override
    public Class<AArticleEntity> getClazz() {
        return AArticleEntity.class;
    }
}
