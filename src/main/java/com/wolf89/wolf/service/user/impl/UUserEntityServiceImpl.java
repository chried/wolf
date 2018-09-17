package com.wolf89.wolf.service.user.impl;

import com.wolf89.wolf.core.dao.AbstractEntityRepository;
import com.wolf89.wolf.core.entity.EntityParameter;
import com.wolf89.wolf.core.service.AbstractEntityServiceImpl;
import com.wolf89.wolf.dao.user.UUserEntityRepository;
import com.wolf89.wolf.model.entity.user.UUserEntity;
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

    /**
     * 查询.
     *
     * @param name 可以是用户名、电话、邮箱.
     * @return 用户信息.
     */
    @Override
    public UUserEntity findByName(String name) {

        LOG.info("获取用户,name=[{}]", name);

        return this.userEntityRepository.findByName(name, EntityParameter.ACTIVE);
    }
}
