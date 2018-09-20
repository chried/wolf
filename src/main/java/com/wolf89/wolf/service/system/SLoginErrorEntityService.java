package com.wolf89.wolf.service.system;

import com.wolf89.wolf.core.service.AbstractEntityService;
import com.wolf89.wolf.model.entity.system.SLoginErrorEntity;

/**
 * service.
 *
 * @author gaoweibing
 */
public interface SLoginErrorEntityService extends AbstractEntityService<SLoginErrorEntity> {

    /**
     * 获取登录错误信息.
     *
     * @param userId
     * @return
     */
    SLoginErrorEntity findByUserId(String userId);

    /**
     * 删除userId错误信息.
     *
     * @param userId 用户id.
     */
    void deleteByUserId(String userId);
}
