package com.wolf89.wolf.dao.user;

import com.wolf89.wolf.core.dao.AbstractEntityRepositoryImpl;
import com.wolf89.wolf.model.entity.user.URegisterEntity;

/**
 * dao实现.
 *
 * @author gaoweibing
 */
public class URegisterEntityRepositoryImpl extends AbstractEntityRepositoryImpl<URegisterEntity> {

    /**
     * 主实体类.
     */
    @Override
    protected Class<URegisterEntity> getClazz() {
        return URegisterEntity.class;
    }
}
