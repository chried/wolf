package com.wolf89.wolf.service.article.impl;

import com.wolf89.wolf.core.dao.AbstractClassifyEntityRepository;
import com.wolf89.wolf.core.service.AbstractClassifyEntityServiceImpl;
import com.wolf89.wolf.dao.article.ATypeEntityRepository;
import com.wolf89.wolf.model.entity.article.ATypeEntity;
import com.wolf89.wolf.service.article.ATypeEntityService;
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
public class ATypeEntityServiceImpl extends AbstractClassifyEntityServiceImpl<ATypeEntity> implements ATypeEntityService {

    private static final Logger LOG = LoggerFactory.getLogger(ATypeEntityServiceImpl.class);

    @Autowired
    private ATypeEntityRepository aTypeEntityRepository;

    @Override
    public Class<ATypeEntity> getClazz() {
        return ATypeEntity.class;
    }

    @Override
    public AbstractClassifyEntityRepository<ATypeEntity> getRepository() {
        return aTypeEntityRepository;
    }
}
