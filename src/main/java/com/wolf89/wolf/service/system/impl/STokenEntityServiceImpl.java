package com.wolf89.wolf.service.system.impl;

import com.wolf89.wolf.core.dao.AbstractEntityRepository;
import com.wolf89.wolf.core.parameter.EntityParameter;
import com.wolf89.wolf.core.service.AbstractEntityServiceImpl;
import com.wolf89.wolf.dao.system.STokenEntityRepository;
import com.wolf89.wolf.model.entity.system.STokenEntity;
import com.wolf89.wolf.service.system.STokenEntityService;
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
public class STokenEntityServiceImpl extends AbstractEntityServiceImpl<STokenEntity> implements STokenEntityService {

    private static final Logger LOG = LoggerFactory.getLogger(STokenEntityServiceImpl.class);

    @Autowired
    private STokenEntityRepository sTokenEntityRepository;

    @Override
    public AbstractEntityRepository<STokenEntity> getRepository() {
        return sTokenEntityRepository;
    }

    @Override
    public Class<STokenEntity> getClazz() {
        return STokenEntity.class;
    }

    /**
     * 获取token.
     *
     * @param token token.
     * @return token.
     */
    @Override
    public STokenEntity findByToken(String token) {

        LOG.info("获取token,token=[{}]", token);

        return this.sTokenEntityRepository.findByToken(token, EntityParameter.ACTIVE);
    }
}
