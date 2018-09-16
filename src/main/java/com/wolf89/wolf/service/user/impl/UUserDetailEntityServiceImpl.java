package com.wolf89.wolf.service.user.impl;

import com.wolf89.wolf.core.dao.AbstractEntityRepository;
import com.wolf89.wolf.core.service.AbstractEntityServiceImpl;
import com.wolf89.wolf.dao.user.UUserDetailEntityRepository;
import com.wolf89.wolf.entity.user.UUserDetailEntity;
import com.wolf89.wolf.service.user.UUserDetailEntityService;
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
public class UUserDetailEntityServiceImpl extends AbstractEntityServiceImpl<UUserDetailEntity> implements UUserDetailEntityService {

    private static final Logger LOG = LoggerFactory.getLogger(UUserDetailEntityServiceImpl.class);

    @Autowired
    private UUserDetailEntityRepository uUserDetailEntityRepository;

    @Override
    public AbstractEntityRepository<UUserDetailEntity> getRepository() {
        return uUserDetailEntityRepository;
    }

    @Override
    public Class<UUserDetailEntity> getClazz() {
        return UUserDetailEntity.class;
    }
}
