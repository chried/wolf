package com.wolf89.wolf.service.system.impl;

import com.wolf89.wolf.core.dao.AbstractEntityRepository;
import com.wolf89.wolf.core.parameter.EntityParameter;
import com.wolf89.wolf.core.service.AbstractEntityServiceImpl;
import com.wolf89.wolf.dao.system.SLoginErrorEntityRepository;
import com.wolf89.wolf.model.entity.system.SLoginErrorEntity;
import com.wolf89.wolf.service.system.SLoginErrorEntityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * service.
 *
 * @author gaoweibing
 */
@Service
public class SLoginErrorEntityServiceImpl extends AbstractEntityServiceImpl<SLoginErrorEntity> implements SLoginErrorEntityService {

    private static final Logger LOG = LoggerFactory.getLogger(SLoginErrorEntityServiceImpl.class);

    @Autowired
    private SLoginErrorEntityRepository sLoginErrorEntityRepository;

    @Override
    public AbstractEntityRepository<SLoginErrorEntity> getRepository() {
        return sLoginErrorEntityRepository;
    }

    @Override
    public Class<SLoginErrorEntity> getClazz() {
        return SLoginErrorEntity.class;
    }

    /**
     * 获取登录错误信息.
     *
     * @param userId
     * @return
     */
    @Override
    public SLoginErrorEntity findByUserId(String userId) {

        LOG.info("根据用户获取错误信息,userId=[{}]", userId);

        return sLoginErrorEntityRepository.findByUserId(userId, EntityParameter.ACTIVE);
    }

    /**
     * 删除userId错误信息.
     *
     * @param userId 用户id.
     */
    @Override
    @Transactional
    public void deleteByUserId(String userId) {

        LOG.info("根据userId删除,userId=[{}]", userId);

        this.sLoginErrorEntityRepository.deleteByUserId(userId);

    }
}
