package com.wolf89.wolf.service.user;

import com.wolf89.wolf.core.service.AbstractEntityService;
import com.wolf89.wolf.model.entity.user.URoleEntity;

import java.util.List;

/**
 * service.
 *
 * @author gaoweibing
 */
public interface URoleEntityService extends AbstractEntityService<URoleEntity> {

    /**
     * 根据用户id获取.
     *
     * @param userId 用户id.
     * @return 角色列表.
     */
    List<URoleEntity> queryByUserId_(String userId);
}
