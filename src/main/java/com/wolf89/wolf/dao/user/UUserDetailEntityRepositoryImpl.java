package com.wolf89.wolf.dao.user;

import com.wolf89.wolf.core.dao.AbstractEntityRepositoryImpl;
import com.wolf89.wolf.model.entity.user.UUserDetailEntity;

/**
 * dao实现.
 *
 * @author chried
 */
public class UUserDetailEntityRepositoryImpl extends AbstractEntityRepositoryImpl<UUserDetailEntity> {

    /**
     * 主实体类.
     */
    @Override
    protected Class<UUserDetailEntity> getClazz() {
        return UUserDetailEntity.class;
    }
}
