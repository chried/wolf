package com.wolf89.wolf.dao.system;

import com.wolf89.wolf.core.dao.AbstractEntityRepositoryImpl;
import com.wolf89.wolf.model.entity.system.SLoginInfoEntity;

/**
 * @author gaoweibing
 */
public class SLoginInfoEntityRepositoryImpl extends AbstractEntityRepositoryImpl<SLoginInfoEntity> {

    /**
     * 主实体类.
     */
    @Override
    protected Class<SLoginInfoEntity> getClazz() {
        return SLoginInfoEntity.class;
    }
}
