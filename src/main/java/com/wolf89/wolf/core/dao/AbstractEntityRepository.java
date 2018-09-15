package com.wolf89.wolf.core.dao;

import com.wolf89.wolf.core.entity.AbstractEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 定义父级dao层.
 */
public interface AbstractEntityRepository<T extends AbstractEntity> extends JpaRepository<T, String> {

    /**
     * 根据ID查询.
     *
     * @param id 主键编号
     * @return 单个实体
     */
    T findById_(String id);

}
