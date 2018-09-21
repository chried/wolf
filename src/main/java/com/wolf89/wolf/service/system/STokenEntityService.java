package com.wolf89.wolf.service.system;

import com.wolf89.wolf.core.service.AbstractEntityService;
import com.wolf89.wolf.model.entity.system.STokenEntity;

/**
 * service.
 *
 * @author gaoweibing
 */
public interface STokenEntityService extends AbstractEntityService<STokenEntity> {

    /**
     * 获取token.
     * @param token token.
     * @return token.
     */
    STokenEntity findByToken(String token);
}
