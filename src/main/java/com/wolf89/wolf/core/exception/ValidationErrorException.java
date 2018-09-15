/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wolf89.wolf.core.exception;

import com.wolf89.wolf.core.validator.ValidationError;
import com.wolf89.wolf.core.validator.ValidationResult;

import javax.validation.ValidationException;
import java.util.List;

/**
 * 带有详情的验证异常.
 *
 * @author gaoweibing
 */
public class ValidationErrorException extends ValidationException {

    /**
     * 验证异常.
     */
    private final ValidationResult result;

    /**
     * 构造函数.
     *
     * @param message          消息
     * @param validationResult 验证结果
     */
    public ValidationErrorException(String message, ValidationResult validationResult) {
        super(message);

        this.result = validationResult;
    }

    /**
     * 验证异常.
     *
     * @return 验证异常
     */
    public List<ValidationError> getValidationErrors() {
        return this.result.getErrors();
    }

}
