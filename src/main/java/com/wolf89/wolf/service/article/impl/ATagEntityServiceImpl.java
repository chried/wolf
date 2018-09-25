package com.wolf89.wolf.service.article.impl;

import com.wolf89.wolf.core.dao.AbstractEntityRepository;
import com.wolf89.wolf.core.service.AbstractEntityServiceImpl;
import com.wolf89.wolf.dao.article.ATagEntityRepository;
import com.wolf89.wolf.model.entity.article.ATagEntity;
import com.wolf89.wolf.service.article.ATagEntityService;
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
public class ATagEntityServiceImpl extends AbstractEntityServiceImpl<ATagEntity> implements ATagEntityService {

    private static final Logger LOG = LoggerFactory.getLogger(ATagEntityServiceImpl.class);

    @Autowired
    private ATagEntityRepository aTagEntityRepository;

    @Override
    public AbstractEntityRepository<ATagEntity> getRepository() {
        return aTagEntityRepository;
    }

    @Override
    public Class<ATagEntity> getClazz() {
        return ATagEntity.class;
    }
}
