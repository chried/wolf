package com.wolf89.wolf.dao.user;

import com.wolf89.wolf.core.dao.AbstractEntityRepositoryImpl;
import com.wolf89.wolf.model.entity.user.UUserEntity;

/**
 * dao实现.
 *
 * @author chried
 */
public class UUserEntityRepositoryImpl extends AbstractEntityRepositoryImpl<UUserEntity> {

    /**
     * 主实体类.
     */
    @Override
    protected Class<UUserEntity> getClazz() {
        return UUserEntity.class;
    }
}
