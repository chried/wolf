package com.wolf89.wolf.core.service;

import com.wolf89.wolf.core.entity.Refer;
import com.wolf89.wolf.core.output.ApiOutput;
import com.wolf89.wolf.model.entity.system.AbstractClassifyEntity;

import java.util.List;

/**
 * 分类service父级.
 *
 * @param <T>
 * @author chried
 */
public interface AbstractClassifyEntityService<T extends AbstractClassifyEntity> extends AbstractEntityService<T> {

    /**
     * 获取下拉选项.
     *
     * @return 分类下拉选项.
     */
    ApiOutput<List<Refer>> selection();

    /**
     * 获取下拉选项.
     *
     * @param keyword
     * @return 分类下拉选项.
     */
    ApiOutput<List<Refer>> selection(String keyword);

    /**
     * 获取下拉选项.
     *
     * @param lead 上级
     * @return 分类下拉选项
     */
    ApiOutput<List<Refer>> selectionByLead(String lead);

    /**
     * 获取下拉选项.
     *
     * @param lead
     * @param keyword
     * @return
     */
    ApiOutput<List<Refer>> selectionByLead(String lead, String keyword);

    /**
     * 按上级代码查询.
     *
     * @param lead    上级代码
     * @param visible 是否可见
     * @return 分类列表
     */
    ApiOutput<List<T>> queryByLead(String lead, boolean visible);

    /**
     * 按上级代码查询.
     *
     * @param lead    上级代码
     * @param visible 是否可见
     * @return 分类列表
     */
    List<T> queryByLead_(String lead, boolean visible);

    /**
     * 按上级代码查询.
     *
     * @param lead    上级代码
     * @param visible 是否可见
     * @param keyword 关键词
     * @return 分类列表
     */
    List<T> queryByLead_(String lead, boolean visible, String keyword);

    /**
     * 验证输入的代码是否可用.
     *
     * @param id   主键编号
     * @param code 分类代码
     * @return 合法的时候返回消息，不合法的时候直接抛出验证异常
     */
    ApiOutput<String> validatorByCode(String id, String code);

    /**
     * 按代码查询对象.
     *
     * @param code 代码
     * @return 分类对象
     */
    ApiOutput<T> findByCode(String code);

    /**
     * 按代码查询对象.
     *
     * @param code 代码
     * @return 分类对象
     */
    T findByCode_(String code);

    /**
     * 验证输入名字是否合法.
     *
     * @param id   主键编号
     * @param lead 上级代码
     * @param name 名称
     * @return 验证成功时返回消息，不成功时抛出异常
     */
    ApiOutput<String> validatorByName(String id, String lead, String name);

    /**
     * 按名称查询对象.
     *
     * @param lead 上级代码
     * @param name 分类名称
     * @return 数据对象
     */
    ApiOutput<T> findByName(String lead, String name);

    /**
     * 按名称查询对象.
     *
     * @param lead 上级代码
     * @param name 分类名称
     * @return 数据对象
     */
    T findByName_(String lead, String name);
}
