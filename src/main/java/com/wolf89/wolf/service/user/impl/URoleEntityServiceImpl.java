package com.wolf89.wolf.service.user.impl;

import com.wolf89.wolf.core.dao.AbstractEntityRepository;
import com.wolf89.wolf.core.parameter.EntityParameter;
import com.wolf89.wolf.core.service.AbstractEntityServiceImpl;
import com.wolf89.wolf.dao.user.URoleEntityRepository;
import com.wolf89.wolf.model.entity.user.URoleEntity;
import com.wolf89.wolf.service.user.URoleEntityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * service实现.
 *
 * @author gaoweibing
 */
@Service
public class URoleEntityServiceImpl extends AbstractEntityServiceImpl<URoleEntity> implements URoleEntityService {

    private static final Logger LOG = LoggerFactory.getLogger(URoleEntityServiceImpl.class);

    @Autowired
    private URoleEntityRepository uRoleEntityRepository;

    @Override
    public AbstractEntityRepository<URoleEntity> getRepository() {
        return uRoleEntityRepository;
    }

    @Override
    public Class<URoleEntity> getClazz() {
        return URoleEntity.class;
    }

    /**
     * 根据用户id获取.
     *
     * @param userId 用户id.
     * @return 角色列表.
     */
    @Override
    public List<URoleEntity> queryByUserId_(String userId) {

        LOG.info("根据用户获取,userId=[{}]", userId);

        return this.uRoleEntityRepository.queryByUserId(userId, LocalDateTime.now(), EntityParameter.ACTIVE);
    }
}
