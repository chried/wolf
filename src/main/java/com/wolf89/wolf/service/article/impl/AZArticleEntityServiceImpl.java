package com.wolf89.wolf.service.article.impl;

import com.wolf89.wolf.core.dao.AbstractEntityRepository;
import com.wolf89.wolf.core.service.AbstractEntityServiceImpl;
import com.wolf89.wolf.dao.article.AZArticleEntityRepository;
import com.wolf89.wolf.model.entity.article.AZArticleEntity;
import com.wolf89.wolf.service.article.AZArticleEntityService;
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
public class AZArticleEntityServiceImpl extends AbstractEntityServiceImpl<AZArticleEntity> implements AZArticleEntityService {

    private static final Logger LOG = LoggerFactory.getLogger(AZArticleEntityServiceImpl.class);

    @Autowired
    private AZArticleEntityRepository azArticleEntityRepository;

    @Override
    public AbstractEntityRepository<AZArticleEntity> getRepository() {
        return azArticleEntityRepository;
    }

    @Override
    public Class<AZArticleEntity> getClazz() {
        return AZArticleEntity.class;
    }
}
