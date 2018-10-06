package com.wolf89.wolf.service.article.impl;

import com.wolf89.wolf.core.dao.AbstractEntityRepository;
import com.wolf89.wolf.core.service.AbstractEntityServiceImpl;
import com.wolf89.wolf.dao.article.AEArticleEntityRepository;
import com.wolf89.wolf.model.entity.article.AEArticleEntity;
import com.wolf89.wolf.service.article.AEArticleEntityService;
import com.wolf89.wolf.service.article.AbstractArticleEntityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * service实现.
 *
 * @author chried
 */
@Service
public class AEArticleEntityServiceImpl extends AbstractEntityServiceImpl<AEArticleEntity> implements AEArticleEntityService {

    private static final Logger LOG = LoggerFactory.getLogger(AEArticleEntityServiceImpl.class);

    @Autowired
    private AEArticleEntityRepository aeArticleEntityRepository;

    @Autowired
    private AbstractArticleEntityService abstractArticleEntityService;

    @Override
    public AbstractEntityRepository<AEArticleEntity> getRepository() {
        return aeArticleEntityRepository;
    }

    @Override
    public Class<AEArticleEntity> getClazz() {
        return AEArticleEntity.class;
    }

    /**
     * 保存前.
     *
     * @param aeArticleEntity 对象.
     */
    @Override
    protected void beforeSave(AEArticleEntity aeArticleEntity) {

        LOG.info("文章提交");

        abstractArticleEntityService.beforeSave_(aeArticleEntity);

    }
}
