package com.wolf89.wolf.service.article.impl;

import com.wolf89.wolf.core.dao.AbstractEntityRepository;
import com.wolf89.wolf.core.service.AbstractEntityServiceImpl;
import com.wolf89.wolf.dao.article.AColumnEntityRepository;
import com.wolf89.wolf.model.entity.article.AColumnEntity;
import com.wolf89.wolf.service.article.AColumnEntityService;
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
public class AColumnEntityServiceImpl extends AbstractEntityServiceImpl<AColumnEntity> implements AColumnEntityService {

    private static final Logger LOG = LoggerFactory.getLogger(AColumnEntityServiceImpl.class);

    @Autowired
    private AColumnEntityRepository aColumnEntityRepository;

    @Override
    public AbstractEntityRepository<AColumnEntity> getRepository() {
        return aColumnEntityRepository;
    }

    @Override
    public Class<AColumnEntity> getClazz() {
        return AColumnEntity.class;
    }
}
