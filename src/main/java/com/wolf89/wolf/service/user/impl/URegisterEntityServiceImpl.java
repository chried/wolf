package com.wolf89.wolf.service.user.impl;

import com.wolf89.wolf.core.dao.AbstractEntityRepository;
import com.wolf89.wolf.core.service.AbstractEntityServiceImpl;
import com.wolf89.wolf.dao.user.URegisterEntityRepository;
import com.wolf89.wolf.model.entity.user.URegisterEntity;
import com.wolf89.wolf.service.user.URegisterEntityService;
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
public class URegisterEntityServiceImpl extends AbstractEntityServiceImpl<URegisterEntity> implements URegisterEntityService {

    private static final Logger LOG = LoggerFactory.getLogger(URegisterEntityServiceImpl.class);

    @Autowired
    private URegisterEntityRepository uRegisterEntityRepository;

    @Override
    public AbstractEntityRepository<URegisterEntity> getRepository() {
        return uRegisterEntityRepository;
    }

    @Override
    public Class<URegisterEntity> getClazz() {
        return URegisterEntity.class;
    }
}
