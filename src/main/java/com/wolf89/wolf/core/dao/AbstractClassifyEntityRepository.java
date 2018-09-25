package com.wolf89.wolf.core.dao;

import com.wolf89.wolf.model.entity.system.AbstractClassifyEntity;

import java.util.List;

/**
 * 分类dao.
 *
 * @param <T>
 * @author gaoweibing
 */
public interface AbstractClassifyEntityRepository<T extends AbstractClassifyEntity> extends AbstractEntityRepository<T> {

    /**
     * 根据上级代码查询.
     *
     * @param lead 上级代码
     * @return 数据列表
     */
    List<T> queryByLead_(String lead);

    /**
     * 根据上级代码查询.
     *
     * @param lead    上级代码
     * @param keyword
     * @return 数据列表
     */
    List<T> queryByLead_(String lead, String keyword);

    /**
     * 根据上级代码查询. 可以控制是否仅获取可见的
     *
     * @param lead    上级代码
     * @param visible 是否可见
     * @return 数据列表
     */
    List<T> queryByLead_(String lead, boolean visible);

    /**
     * 根据上级代码查询.可以控制是否仅获取可见的
     *
     * @param lead    上级代码
     * @param visible 是否可见
     * @param keyword
     * @return 数据列表
     */
    List<T> queryByLead_(String lead, boolean visible, String keyword);


    /**
     * 根据代码查询单条数据.
     *
     * @param code 代码
     * @return 数据对象
     */
    T findByCode_(String code);

    /**
     * 根据名称查询同级别下面的单条数据.
     *
     * @param lead 上级代码
     * @param name 名字
     * @return 数据对象
     */
    T findByName_(String lead, String name);
}
