package com.wolf89.wolf.service.user.impl;

import com.wolf89.wolf.core.dao.AbstractEntityRepository;
import com.wolf89.wolf.core.service.AbstractEntityServiceImpl;
import com.wolf89.wolf.dao.user.UUserRoleEntityRepository;
import com.wolf89.wolf.model.entity.user.UUserRoleEntity;
import com.wolf89.wolf.service.user.UUserRoleEntityService;
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
public class UUserRoleEntityServiceImpl extends AbstractEntityServiceImpl<UUserRoleEntity> implements UUserRoleEntityService {

    private static final Logger LOG = LoggerFactory.getLogger(UUserRoleEntityServiceImpl.class);

    @Autowired
    private UUserRoleEntityRepository uUserRoleEntityRepository;

    @Override
    public AbstractEntityRepository<UUserRoleEntity> getRepository() {
        return uUserRoleEntityRepository;
    }

    @Override
    public Class<UUserRoleEntity> getClazz() {
        return UUserRoleEntity.class;
    }
}
