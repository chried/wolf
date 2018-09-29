/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wolf89.wolf.core.controller;

import com.wolf89.wolf.core.entity.Refer;
import com.wolf89.wolf.core.output.ApiOutput;
import com.wolf89.wolf.core.service.AbstractClassifyEntityService;
import com.wolf89.wolf.model.entity.system.AbstractClassifyEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 通用分类REST服务.
 *
 * @param <T> 通用分类实体
 * @author tangfeifei
 */
public abstract class AbstractClassifyEntityController<T extends AbstractClassifyEntity>
        extends AbstractEntityController<T> {

    @Override
    public abstract AbstractClassifyEntityService<T> getService();

    /**
     * 验证代码是否重复.
     *
     * @param id   主键
     * @param code 代码
     * @return 异步验证结果
     */
    @PostMapping(value = "/validatorByCode")
    public ApiOutput<String> validatorByCode(
            @RequestParam(name = "id", required = false) String id,
            @RequestParam(name = "code") String code) {

        return this.getService().validatorByCode(id, code);
    }

    /**
     * 验证名字是否重复.
     *
     * @param id   主键
     * @param lead 上级
     * @param name 名字
     * @return 异步验证结果
     */
    @PostMapping(value = "/validatorByName")
    public ApiOutput<String> validatorByName(
            @RequestParam(name = "id", required = false) String id,
            @RequestParam(name = "lead", required = false, defaultValue = ".") String lead,
            @RequestParam(name = "name") String name) {

        return this.getService().validatorByName(id, lead, name);
    }

    /**
     * 通过代码获取对象.
     *
     * @param code 代码
     * @return 数据对象
     */
    @GetMapping(value = "/getByCode")
    public ApiOutput<T> getByCode(
            @RequestParam(name = "code") String code) {

        return this.getService().findByCode(code);
    }

    /**
     * 通过名字获取对象.
     *
     * @param lead 上级
     * @param name 名字
     * @return 数据对象
     */
    @GetMapping(value = "/getByName")
    public ApiOutput<T> getByName(
            @RequestParam(name = "lead") String lead,
            @RequestParam(name = "name") String name) {

        return this.getService().findByName(lead, name);
    }

    /**
     * 获取下级分类列表.
     *
     * @param lead    上级
     * @param visible 是否可见
     * @return 数据列表
     */
    @GetMapping(value = "/queryByLead")
    public ApiOutput<List<T>> queryByLead(
            @RequestParam(name = "lead") String lead,
            @RequestParam(name = "visible") boolean visible) {

        return this.getService().queryByLead(lead, visible);
    }

    /**
     * 获取下拉选项.
     *
     * @param lead 上级代码
     * @return 数据列表
     */
    @GetMapping(value = "/selectionByLead")
    public ApiOutput<List<Refer>> selectionByLead(
            @RequestParam(name = "lead") String lead) {

        return this.getService().selectionByLead(lead);
    }

}
