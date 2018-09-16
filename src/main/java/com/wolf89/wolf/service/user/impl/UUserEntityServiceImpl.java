package com.wolf89.wolf.service.user.impl;

import com.wolf89.wolf.core.dao.AbstractEntityRepository;
import com.wolf89.wolf.core.service.AbstractEntityServiceImpl;
import com.wolf89.wolf.dao.user.UUserEntityRepository;
import com.wolf89.wolf.entity.user.UUserEntity;
import com.wolf89.wolf.service.user.UUserEntityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 实现.
 *
 * @author chried
 */
@Service
public class UUserEntityServiceImpl extends AbstractEntityServiceImpl<UUserEntity> implements UUserEntityService {

    private static final Logger LOG = LoggerFactory.getLogger(UUserEntityServiceImpl.class);

    @Autowired
    private UUserEntityRepository userEntityRepository;

    @Override
    public AbstractEntityRepository<UUserEntity> getRepository() {
        return userEntityRepository;
    }

    @Override
    public Class<UUserEntity> getClazz() {
        return UUserEntity.class;
    }
    
}
