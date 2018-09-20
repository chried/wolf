package com.wolf89.wolf.dao.system;

import com.wolf89.wolf.core.dao.AbstractEntityRepositoryImpl;
import com.wolf89.wolf.model.entity.system.SLoginErrorEntity;

/**
 * dao实现.
 *
 * @author gaoweibing
 */
public class SLoginErrorEntityRepositoryImpl extends AbstractEntityRepositoryImpl<SLoginErrorEntity> {

    /**
     * 主实体类.
     */
    @Override
    protected Class<SLoginErrorEntity> getClazz() {
        return SLoginErrorEntity.class;
    }
}
