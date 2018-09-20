package com.wolf89.wolf.dao.user;

import com.wolf89.wolf.core.dao.AbstractEntityRepositoryImpl;
import com.wolf89.wolf.model.entity.user.URoleEntity;

/**
 * dao实现.
 *
 * @author gaoweibing
 */
public class URoleEntityRepositoryImpl extends AbstractEntityRepositoryImpl<URoleEntity> {

    /**
     * 主实体类.
     */
    @Override
    protected Class<URoleEntity> getClazz() {
        return URoleEntity.class;
    }
}
