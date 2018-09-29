package com.wolf89.wolf.dao.system;

import com.wolf89.wolf.core.dao.AbstractClassifyEntityRepositoryImpl;
import com.wolf89.wolf.model.entity.system.SClassifyEntity;

/**
 * dao实现.
 *
 * @author gaoweibing
 */
public class SClassifyEntityRepositoryImpl extends AbstractClassifyEntityRepositoryImpl<SClassifyEntity> {

    @Override
    protected Class<SClassifyEntity> getClazz() {
        return SClassifyEntity.class;
    }
}
