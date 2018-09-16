package com.wolf89.wolf.controller;

import com.wolf89.wolf.core.output.ApiOutput;
import com.wolf89.wolf.dto.user.RegisterForm;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 注册页面控制器.
 *
 * @author chried
 */
@RestController
@RequestMapping(value = "register")
public class RegisterController {

    /**
     * 注册用户.
     *
     * @return 信息.
     */
    @RequestMapping(value = "user")
    public ApiOutput<String> registerUser(@RequestBody @Validated RegisterForm form, BindingResult result) {

        return null;
    }

}
