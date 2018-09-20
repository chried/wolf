package com.wolf89.wolf.service.system.impl;

import com.wolf89.wolf.core.dao.AbstractEntityRepository;
import com.wolf89.wolf.core.service.AbstractEntityServiceImpl;
import com.wolf89.wolf.dao.system.SLoginInfoEntityRepository;
import com.wolf89.wolf.model.entity.system.SLoginInfoEntity;
import com.wolf89.wolf.service.system.SLoginInfoEntityService;
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
public class SLoginInfoEntityServiceImpl extends AbstractEntityServiceImpl<SLoginInfoEntity> implements SLoginInfoEntityService {

    private static final Logger LOG = LoggerFactory.getLogger(SLoginInfoEntityServiceImpl.class);

    @Autowired
    private SLoginInfoEntityRepository sLoginInfoEntityRepository;

    @Override
    public AbstractEntityRepository<SLoginInfoEntity> getRepository() {
        return sLoginInfoEntityRepository;
    }

    @Override
    public Class<SLoginInfoEntity> getClazz() {
        return SLoginInfoEntity.class;
    }
}
