package com.wolf89.wolf.service.article.impl;

import com.wolf89.wolf.core.dao.AbstractEntityRepository;
import com.wolf89.wolf.core.service.AbstractEntityServiceImpl;
import com.wolf89.wolf.dao.article.AZArticleEntityRepository;
import com.wolf89.wolf.model.entity.article.AArticleEntity;
import com.wolf89.wolf.model.entity.article.AZArticleEntity;
import com.wolf89.wolf.service.article.AZArticleEntityService;
import com.wolf89.wolf.service.article.AbstractArticleEntityService;
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

    @Autowired
    private AbstractArticleEntityService abstractArticleEntityService;

    @Override
    public AbstractEntityRepository<AZArticleEntity> getRepository() {
        return azArticleEntityRepository;
    }

    @Override
    public Class<AZArticleEntity> getClazz() {
        return AZArticleEntity.class;
    }

    /**
     * 保存前.
     *
     * @param azArticleEntity 对象.
     */
    @Override
    protected void beforeSave(AZArticleEntity azArticleEntity) {

        LOG.info("文章提交");

        abstractArticleEntityService.beforeSave_(azArticleEntity);

    }
}
