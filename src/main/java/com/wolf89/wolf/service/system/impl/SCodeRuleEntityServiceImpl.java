package com.wolf89.wolf.service.system.impl;

import com.wolf89.wolf.core.dao.AbstractEntityRepository;
import com.wolf89.wolf.core.service.AbstractEntityServiceImpl;
import com.wolf89.wolf.dao.system.SCodeRuleEntityRepository;
import com.wolf89.wolf.model.entity.system.SCodeRuleEntity;
import com.wolf89.wolf.service.system.SCodeRuleEntityService;
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
public class SCodeRuleEntityServiceImpl extends AbstractEntityServiceImpl<SCodeRuleEntity> implements SCodeRuleEntityService {

    private static final Logger LOG = LoggerFactory.getLogger(SCodeRuleEntityServiceImpl.class);

    @Autowired
    private SCodeRuleEntityRepository sCodeRuleEntityRepository;

    @Override
    public AbstractEntityRepository<SCodeRuleEntity> getRepository() {
        return sCodeRuleEntityRepository;
    }

    @Override
    public Class<SCodeRuleEntity> getClazz() {
        return SCodeRuleEntity.class;
    }
}
