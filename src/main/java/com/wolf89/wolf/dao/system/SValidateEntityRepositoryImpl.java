package com.wolf89.wolf.dao.system;

import com.wolf89.wolf.core.dao.AbstractEntityRepositoryImpl;
import com.wolf89.wolf.model.entity.system.SValidateEntity;

/**
 * dao实现.
 *
 * @author chried
 */
public class SValidateEntityRepositoryImpl extends AbstractEntityRepositoryImpl<SValidateEntity> {

    /**
     * 主实体类.
     */
    @Override
    protected Class<SValidateEntity> getClazz() {
        return SValidateEntity.class;
    }
}
