package com.wolf89.wolf.dao.system;

import com.wolf89.wolf.core.dao.AbstractEntityRepositoryImpl;
import com.wolf89.wolf.model.entity.system.STokenEntity;

/**
 * dao实现.
 *
 * @author gaoweibing
 */
public class STokenEntityRepositoryImpl extends AbstractEntityRepositoryImpl<STokenEntity> {

    /**
     * 主实体类.
     */
    @Override
    protected Class<STokenEntity> getClazz() {
        return STokenEntity.class;
    }
}
