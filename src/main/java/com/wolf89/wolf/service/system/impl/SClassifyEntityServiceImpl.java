package com.wolf89.wolf.service.system.impl;

import com.wolf89.wolf.core.dao.AbstractClassifyEntityRepository;
import com.wolf89.wolf.core.service.AbstractClassifyEntityServiceImpl;
import com.wolf89.wolf.dao.system.SClassifyEntityRepository;
import com.wolf89.wolf.model.entity.system.SClassifyEntity;
import com.wolf89.wolf.service.system.SClassifyEntityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * service实现.
 *
 * @author gaoweibing
 */
@Service(value = "sclassifyEntityServiceImpl")
public class SClassifyEntityServiceImpl extends AbstractClassifyEntityServiceImpl<SClassifyEntity> implements SClassifyEntityService {

    private static final Logger LOG = LoggerFactory.getLogger(SClassifyEntityServiceImpl.class);

    @Autowired
    private SClassifyEntityRepository sClassifyEntityRepository;

    @Override
    public AbstractClassifyEntityRepository<SClassifyEntity> getRepository() {
        return sClassifyEntityRepository;
    }

    @Override
    public Class<SClassifyEntity> getClazz() {
        return SClassifyEntity.class;
    }
}
