package com.wolf89.wolf.core.service;

import com.wolf89.wolf.core.entity.AbstractEntity;
import com.wolf89.wolf.core.output.ApiOutput;

import java.util.Collection;

/**
 * 父级service;
 *
 * @author gaoweibing
 */
public interface AbstractEntityService<T extends AbstractEntity> {

    /**
     * 保存.
     *
     * @param t 对象.
     * @return 操作信息.
     */
    ApiOutput<T> save(T t);

    /**
     * 保存.
     *
     * @param t 对象.
     * @return 对象.
     */
    T save_(T t);

    /**
     * 更新.
     *
     * @param t 对象.
     * @return 对象.
     */
    ApiOutput<T> modify(T t);

    /**
     * 更新.
     *
     * @param t 对象.
     * @return 对象.
     */
    T modify_(T t);

    /**
     * 添加.
     *
     * @param t 对象.
     * @return 对象.
     */
    ApiOutput<T> add(T t);

    /**
     * 添加.
     *
     * @param t 对象.
     * @return 对象.
     */
    T add_(T t);

    /**
     * 删除.
     *
     * @param id 主键.
     * @return 信息.
     */
    ApiOutput<String> delete(String id);

    /**
     * 删除.
     *
     * @param id 主键.
     */
    void delete_(String id);

    /**
     * 批量删除.
     *
     * @param ids 主键.
     * @return 信息.
     */
    ApiOutput<String> delete(Collection<String> ids);

    /**
     * 批量删除.
     *
     * @param ids 主键.
     */
    void delete_(Collection<String> ids);


    /**
     * 逻辑删除.
     *
     * @param id 主键.
     * @return 信息.
     */
    ApiOutput<String> remove(String id);

    /**
     * 逻辑删除.
     *
     * @param id 主键.
     */
    void remove_(String id);

    /**
     * 批量逻辑删除.
     *
     * @param ids 主键.
     * @return 信息.
     */
    ApiOutput<String> remove(Collection<String> ids);

    /**
     * 批量逻辑删除.
     *
     * @param ids 主键.
     */
    void remove_(Collection<String> ids);

    /**
     * 获取对象.
     *
     * @param id 主键.
     * @return 对象.
     */
    T get_(String id);

    /**
     * 获取对象.
     *
     * @param id 主键.
     * @return 对象.
     */
    ApiOutput<T> get(String id);

    /**
     * 获取对象.
     *
     * @param id 主键.
     * @return 对象.
     */
    T getOfEdit_(String id);

    /**
     * 获取对象.
     *
     * @param id 主键.
     * @return 对象.
     */
    ApiOutput<T> getOfEdit(String id);
}
