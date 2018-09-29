package com.wolf89.wolf.core.dao;

import com.wolf89.wolf.core.parameter.EntityParameter;
import com.wolf89.wolf.model.entity.system.AbstractClassifyEntity;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * 实现.
 *
 * @param <T>
 * @author gaoweibing
 */
public abstract class AbstractClassifyEntityRepositoryImpl<T extends AbstractClassifyEntity> extends AbstractEntityRepositoryImpl<T> {

    private static final Logger LOG = LoggerFactory.getLogger(AbstractClassifyEntityRepositoryImpl.class);

    @Override
    protected abstract Class<T> getClazz();

    /**
     * 根据上级代码查询.
     *
     * @param lead 上级代码
     * @return 数据列表
     */
    public List<T> queryByLead_(String lead) {
        CriteriaBuilder builder = this.em.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(this.getClazz());

        Root<T> root = query.from(this.getClazz());
        query.select(root);

        query.where(
                builder.equal(root.get("lead"), lead),
                builder.equal(root.get("status_"), EntityParameter.ACTIVE)
        );

        query.orderBy(
                builder.asc(root.get("position")),
                builder.asc(root.get("code")));

        return em.createQuery(query).getResultList();
    }

    public List<T> queryByLead_(String lead, String keyword) {
        LOG.info("lead={},keyword={}", lead, keyword);

        CriteriaBuilder builder = this.em.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(this.getClazz());

        Root<T> root = query.from(this.getClazz());
        query.select(root);

        List<Predicate> restrictions = new ArrayList<>();

        if (!StringUtils.isBlank(lead)) {
            restrictions.add(builder.equal(root.get("lead"), lead));
        }

        if (!StringUtils.isBlank(keyword)) {
            restrictions.add(builder.or(
                    builder.like(root.get("code"), keyword + "%"),
                    builder.like(root.get("code"), "%" + keyword),
                    builder.like(root.get("name"), "%" + keyword + "%")));
        }

        restrictions.add(builder.equal(root.get("status_"), EntityParameter.ACTIVE));

        Predicate[] predicates = new Predicate[restrictions.size()];

        query.where(restrictions.toArray(predicates));

        query.orderBy(
                builder.asc(root.get("position")),
                builder.asc(root.get("code")));

        return em.createQuery(query).getResultList();
    }

    /**
     * 根据上级代码查询.
     * <pre>
     * 可以控制是否仅获取可见的
     * </pre>
     *
     * @param lead    上级代码
     * @param visible 是否可见
     * @return 数据列表
     */
    public List<T> queryByLead_(String lead, boolean visible) {

        CriteriaBuilder builder = this.em.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(this.getClazz());

        Root<T> root = query.from(this.getClazz());
        query.select(root);

        query.where(
                builder.equal(root.get("lead"), lead),
                builder.equal(root.get("visible"), visible),
                builder.equal(root.get("status_"), EntityParameter.ACTIVE)
        );

        query.orderBy(
                builder.asc(root.get("position")),
                builder.asc(root.get("code")));

        return em.createQuery(query).getResultList();
    }

    public List<T> queryByLead_(String lead, boolean visible, String keyword) {

        LOG.info("lead={},keyword={}", lead, keyword);

        CriteriaBuilder builder = this.em.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(this.getClazz());

        Root<T> root = query.from(this.getClazz());
        query.select(root);

        List<Predicate> restrictions = new ArrayList<>();

        if (!StringUtils.isBlank(lead)) {
            restrictions.add(builder.equal(root.get("lead"), lead));
        }

        restrictions.add(builder.equal(root.get("visible"), visible));

        if (!StringUtils.isBlank(keyword)) {
            restrictions.add(builder.or(
                    builder.like(root.get("code"), keyword + "%"),
                    builder.like(root.get("code"), "%" + keyword),
                    builder.like(root.get("name"), "%" + keyword + "%")));
        }

        restrictions.add(builder.equal(root.get("status_"), EntityParameter.ACTIVE));

        Predicate[] predicates = new Predicate[restrictions.size()];

        query.where(restrictions.toArray(predicates));

        query.orderBy(
                builder.asc(root.get("position")),
                builder.asc(root.get("code")));

        return em.createQuery(query).getResultList();
    }

    /**
     * 根据代码查询单条数据.
     *
     * @param code 代码
     * @return 数据对象
     */
    public T findByCode_(String code) {
        CriteriaBuilder builder = this.em.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(this.getClazz());

        Root<T> root = query.from(this.getClazz());
        query.select(root);

        query.where(
                builder.equal(root.get("code"), code),
                builder.equal(root.get("status_"), EntityParameter.ACTIVE)
        );

        try {
            return em.createQuery(query)
                    .setMaxResults(1)
                    .getSingleResult();
        } catch (NoResultException nre) {
        }

        return null;
    }

    /**
     * 根据名称查询同级别下面的单条数据.
     *
     * @param lead 上级代码
     * @param name 名称
     * @return 数据对象
     */
    public T findByName_(String lead, String name) {
        CriteriaBuilder builder = this.em.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(this.getClazz());

        Root<T> root = query.from(this.getClazz());
        query.select(root);

        query.where(
                builder.equal(root.get("lead"), lead),
                builder.equal(root.get("name"), name),
                builder.equal(root.get("status_"), EntityParameter.ACTIVE)
        );

        try {
            return em.createQuery(query)
                    .setMaxResults(1)
                    .getSingleResult();
        } catch (NoResultException nre) {
        }

        return null;
    }
}
