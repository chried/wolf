package com.wolf89.wolf.controller.user.auth;

import com.wolf89.wolf.core.controller.AbstractEntityController;
import com.wolf89.wolf.core.service.AbstractEntityService;
import com.wolf89.wolf.model.entity.user.UUserEntity;
import com.wolf89.wolf.service.user.UUserEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户控制器.
 *
 * @author chried
 */
@RestController
@RequestMapping(value = "user")
public class UserController extends AbstractEntityController<UUserEntity> {

    @Autowired
    private UUserEntityService uUserEntityService;

    @Override
    public AbstractEntityService getService() {
        return uUserEntityService;
    }


}
