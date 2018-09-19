package com.wolf89.wolf.controller;

import com.wolf89.wolf.core.output.ApiOutput;
import com.wolf89.wolf.dto.user.RegisterForm;
import com.wolf89.wolf.service.user.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 注册页面控制器.
 *
 * @author chried
 */
@RestController
@RequestMapping(value = "rest/register")
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    /**
     * 注册用户.
     *
     * @return 信息.
     */
    @PostMapping(value = "user")
    public ApiOutput<String> registerUser(@RequestBody @Validated RegisterForm form, BindingResult result) {

        return registerService.registerUser(form);
    }

}
