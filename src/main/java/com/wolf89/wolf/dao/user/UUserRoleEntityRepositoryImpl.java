package com.wolf89.wolf.dao.user;

import com.wolf89.wolf.core.dao.AbstractEntityRepositoryImpl;
import com.wolf89.wolf.model.entity.user.UUserRoleEntity;

/**
 * dao实现.
 *
 * @author gaoweibing
 */
public class UUserRoleEntityRepositoryImpl extends AbstractEntityRepositoryImpl<UUserRoleEntity> {

    /**
     * 主实体类.
     */
    @Override
    protected Class<UUserRoleEntity> getClazz() {
        return UUserRoleEntity.class;
    }
}
