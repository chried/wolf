package com.wolf89.wolf.core.service;

import com.wolf89.wolf.core.entity.AbstractEntity;
import com.wolf89.wolf.core.output.ApiOutput;

import java.util.Collection;
import java.util.List;

/**
 * 父级service;
 *
 * <pre>
 *     规则定义如下：
 *     1、如果查询单个对象，用find开头，如果返回内部对象方法后面加“_”，如果需要返回ApiOutput结构，那么不需要增加；
 *     例如：SUserEntity findById_(String id);ApiOutput<SUserEntity> findById(String id);
 *     2、查询多个对象，用query开头，后缀跟规则1一样。
 *     3、定义规则:
 *     <table>
 *         <tr><td>方式</td><td>命名开头</td></tr>
 *         <tr><td>删除</td><td>delete</td></tr>
 *         <tr><td>单个查找</td><td>find</td></tr>
 *         <tr><td>多个查找</td> <td>query</td></tr>
 *         <tr><td>添加</td><td>add</td></tr>
 *     </table>
 * </pre>
 *
 * @author gaoweibing
 */
public interface AbstractEntityService<T extends AbstractEntity> extends AbstractService {

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

    /**
     * 查询所有.
     *
     * @return 对象.
     */
    List<T> queryAll_();

    /**
     * 查询所有.
     *
     * @return 对象.
     */
    ApiOutput<List<T>> queryAll();
}
