package com.wolf89.wolf.service.user;

import com.wolf89.wolf.core.output.ApiOutput;
import com.wolf89.wolf.core.service.AbstractService;
import com.wolf89.wolf.dto.user.RegisterForm;

/**
 * 注册接口.
 *
 * @author chried
 */
public interface RegisterService extends AbstractService {

    /**
     * 用户注册.
     *
     * @param form 参数.
     * @return 操作信息.
     */
    ApiOutput<String> registerUser(RegisterForm form);
}
