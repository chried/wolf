package com.wolf89.wolf.controller.site.auth;

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
public class UserController {

    @Autowired
    private UUserEntityService uUserEntityService;

}
