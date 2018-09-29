package com.wolf89.wolf.dao.system;

import com.wolf89.wolf.core.dao.AbstractEntityRepositoryImpl;
import com.wolf89.wolf.model.entity.system.SCodeRuleEntity;

/**
 * dao实现.
 *
 * @author gaoweibing
 */
public class SCodeRuleEntityRepositoryImpl extends AbstractEntityRepositoryImpl<SCodeRuleEntity> {

    /**
     * 主实体类.
     */
    @Override
    protected Class<SCodeRuleEntity> getClazz() {
        return SCodeRuleEntity.class;
    }
}
