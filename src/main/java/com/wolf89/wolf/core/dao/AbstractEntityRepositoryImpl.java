package com.wolf89.wolf.core.dao;

import com.wolf89.wolf.core.entity.EntityParameter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * 实现.
 *
 * @param <T>
 * @author gaoweibing
 */
public class AbstractEntityRepositoryImpl<T> {

    private static final Logger LOG = LoggerFactory.getLogger(AbstractEntityRepositoryImpl.class);

    /**
     * 实体管理器.
     * <pre>
     * 按照微服务的设计思想，原则上一个项目只引用一个数据源，只访问一个数据库.
     * </pre>
     */
    @PersistenceContext
    protected EntityManager em;

    /**
     * 主实体类.
     */
    protected Class<T> entityClass;

    /**
     * 根据ID查询.
     *
     * @param id 主键编号
     * @return 单个实体
     */
    public T findById_(String id) {

        CriteriaBuilder builder = this.em.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(entityClass);

        Root<T> root = query.from(entityClass);
        query.select(root);

        query.where(
                builder.equal(root.get("id"), id),
                builder.equal(root.get("extend").get("status_"), EntityParameter.ACTIVE)
        );

        try {
            return em.createQuery(query).getSingleResult();
        } catch (NoResultException nre) {
            LOG.warn("实体{}没有找到主键为{}的数据.", entityClass.getName(), id);
        }

        return null;
    }

}
