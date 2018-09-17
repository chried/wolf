package com.wolf89.wolf.service.user;

import com.wolf89.wolf.core.service.AbstractEntityService;
import com.wolf89.wolf.model.entity.user.UUserEntity;

public interface UUserEntityService extends AbstractEntityService<UUserEntity> {

    /**
     * 查询.
     *
     * @param name 可以是用户名、电话、邮箱.
     * @return 用户信息.
     */
    UUserEntity findByName(String name);
}
