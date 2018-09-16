package com.wolf89.wolf.service.system.impl;

import com.wolf89.wolf.core.dao.AbstractEntityRepository;
import com.wolf89.wolf.core.service.AbstractEntityServiceImpl;
import com.wolf89.wolf.dao.system.SValidateEntityRepository;
import com.wolf89.wolf.entity.system.SValidateEntity;
import com.wolf89.wolf.service.system.SValidateEntityService;
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
public class SValidateEntityServiceImpl extends AbstractEntityServiceImpl<SValidateEntity> implements SValidateEntityService {

    private static final Logger LOG = LoggerFactory.getLogger(SValidateEntityServiceImpl.class);

    @Autowired
    private SValidateEntityRepository sValidateEntityRepository;

    @Override
    public AbstractEntityRepository<SValidateEntity> getRepository() {
        return sValidateEntityRepository;
    }

    @Override
    public Class<SValidateEntity> getClazz() {
        return SValidateEntity.class;
    }
}
