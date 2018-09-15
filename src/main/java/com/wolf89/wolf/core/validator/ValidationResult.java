/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wolf89.wolf.core.validator;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 验证错误结构体.
 *
 * @author tangfeifei
 */
public class ValidationResult implements Serializable {

    /**
     * 验证错误列表.
     */
    private final List<ValidationError> errors;

    /**
     * 默认构造函数.
     */
    public ValidationResult() {
        this.errors = new ArrayList<>();
    }

    /**
     * 添加错误.
     *
     * @param error 错误内容.
     */
    public void addError(ValidationError error) {
        errors.add(error);
    }

    /**
     * 添加错误.
     *
     * @param field   错误属性
     * @param message 错误消息
     */
    public void addError(String field, String message) {
        errors.add(new ValidationError(field, message));
    }

    /**
     * 是否有错误.
     *
     * @return 如果错误列表不为空则返回true
     */
    public boolean hasErrors() {
        return !this.errors.isEmpty();
    }

    /**
     * 验证错误.
     *
     * @return the errors
     */
    public List<ValidationError> getErrors() {
        return errors;
    }

}
