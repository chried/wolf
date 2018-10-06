package com.wolf89.wolf.service.article.impl;

import com.wolf89.wolf.core.dao.AbstractEntityRepository;
import com.wolf89.wolf.core.service.AbstractEntityServiceImpl;
import com.wolf89.wolf.dao.article.AArticleEntityRepository;
import com.wolf89.wolf.model.entity.article.AArticleEntity;
import com.wolf89.wolf.service.article.AArticleEntityService;
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
public class AArticleEntityServiceImpl extends AbstractEntityServiceImpl<AArticleEntity> implements AArticleEntityService {

    private static final Logger LOG = LoggerFactory.getLogger(AArticleEntityServiceImpl.class);

    @Autowired
    private AArticleEntityRepository aArticleEntityRepository;

    @Autowired
    private AbstractArticleEntityService abstractArticleEntityService;

    @Override
    public AbstractEntityRepository<AArticleEntity> getRepository() {
        return aArticleEntityRepository;
    }

    @Override
    public Class<AArticleEntity> getClazz() {
        return AArticleEntity.class;
    }

    /**
     * 保存前.
     *
     * @param aArticleEntity 对象.
     */
    @Override
    protected void beforeSave(AArticleEntity aArticleEntity) {

        LOG.info("文章提交");

        abstractArticleEntityService.beforeSave_(aArticleEntity);

    }
}
