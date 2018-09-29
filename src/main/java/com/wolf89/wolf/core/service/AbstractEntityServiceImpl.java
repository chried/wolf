package com.wolf89.wolf.core.service;

import com.wolf89.wolf.core.dao.AbstractEntityRepository;
import com.wolf89.wolf.core.entity.AbstractEntity;
import com.wolf89.wolf.core.parameter.EntityParameter;
import com.wolf89.wolf.core.output.ApiOutput;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.ValidationException;
import java.lang.reflect.InvocationTargetException;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

/**
 * service实现.
 *
 * @author gaoweibing
 */
public abstract class AbstractEntityServiceImpl<T extends AbstractEntity> implements AbstractEntityService<T>, AbstractService {

    private static final Logger LOG = LoggerFactory.getLogger(AbstractEntityServiceImpl.class);

    public abstract AbstractEntityRepository<T> getRepository();

    public abstract Class<T> getClazz();


    /**
     * 保存前.
     *
     * @param t 对象.
     */
    protected void beforeSave(T t) {

    }

    /**
     * 保存后.
     *
     * @param t 对象.
     */
    protected void afterSave(T t) {

    }

    /**
     * 保存.
     *
     * @param t 对象.
     * @return 操作信息.
     */
    @Override
    public ApiOutput<T> save(T t) {

        return ApiOutput.of(this.save_(t));

    }

    /**
     * 保存.
     *
     * @param t 对象.
     * @return 对象.
     */
    @Override
    public T save_(T t) {

        beforeSave(t);

        T result = null;

        if (StringUtils.isNotBlank(t.getId())) {

            result = this.modify_(t);

        } else {
            result = this.add_(t);
        }

        if (result == null) {
            throw new ValidationException("保存失败,对象不存在");
        }

        afterSave(result);

        return result;
    }

    /**
     * 更新.
     *
     * @param t 对象.
     * @return 对象.
     */
    @Override
    public ApiOutput<T> modify(T t) {

        return ApiOutput.of(this.modify_(t));

    }

    /**
     * 更新.
     *
     * @param t 对象.
     * @return 对象.
     */
    @Override
    public T modify_(T t) {

        if (StringUtils.isBlank(t.getId())) {
            throw new ValidationException("主键id不存在");
        }

        t.setUpdate_(LocalDateTime.now());

        return getRepository().save(t);

    }

    /**
     * 添加.
     *
     * @param t 对象.
     * @return 对象.
     */
    @Override
    public ApiOutput<T> add(T t) {

        return ApiOutput.of(this.add_(t));

    }

    /**
     * 添加.
     *
     * @param t 对象.
     * @return 对象.
     */
    @Override
    public T add_(T t) {

        t.setId(UUID.randomUUID().toString());

        /**
         * 此处预防特殊处理.
         * <pre>
         *     例如，某个实体类的创建需要用到时间作为参数，跟其他数据同步。
         * </pre>
         */
        if (t.getInsert_() == null) {
            t.setInsert_(LocalDateTime.now());
        }

        if (t.getUpdate_() == null) {
            t.setUpdate_(t.getInsert_());
        }

        t.setStatus_(EntityParameter.ACTIVE);

        return this.getRepository().save(t);
    }

    /**
     * 删除.
     *
     * @param id 主键.
     * @return 信息.
     */
    @Override
    public ApiOutput<String> delete(String id) {

        this.delete_(id);

        return ApiOutput.of("删除成功");
    }

    /**
     * 删除.
     *
     * @param id 主键.
     */
    @Override
    public void delete_(String id) {

        getRepository().deleteById(id);

    }

    /**
     * 逻辑删除.
     *
     * @param id 主键.
     * @return 信息.
     */
    @Override
    public ApiOutput<String> remove(String id) {

        this.remove_(id);

        return ApiOutput.of("删除成功");
    }

    /**
     * 获取对象.
     *
     * @param id 主键.
     * @return 对象.
     */
    @Override
    public ApiOutput<T> get(String id) {

        return ApiOutput.of(this.get_(id));
    }

    /**
     * 获取对象.
     *
     * @param id 主键.
     * @return 对象.
     */
    @Override
    public ApiOutput<T> getOfEdit(String id) {

        return ApiOutput.of(this.getOfEdit_(id));
    }

    /**
     * 逻辑删除.
     *
     * @param id 主键.
     */
    @Override
    public void remove_(String id) {

        T t = this.get_(id);

        if (t == null) {
            throw new ValidationException("对象不存在,id=[" + id + "]");
        }

        t.setDelete_(LocalDateTime.now());
        t.setStatus_(EntityParameter.REMOVE);

        this.modify_(t);

    }

    /**
     * 获取对象.
     *
     * @param id 主键.
     * @return 对象.
     */
    @Override
    public T get_(String id) {

        return getRepository().findById_(id);

    }

    /**
     * 获取对象.
     *
     * @param id 主键.
     * @return 对象.
     */
    @Override
    public T getOfEdit_(String id) {

        T t = null;

        if (StringUtils.isNotBlank(id)) {
            t = this.get_(id);
        }

        if (t == null) {
            try {
                return getClazz().getConstructor().newInstance();
            } catch (InstantiationException | InvocationTargetException |
                    NoSuchMethodException | IllegalAccessException e) {
                LOG.error("对象初始化异常:{}", e);
            }
        }

        return t;
    }

    /**
     * 批量逻辑删除.
     *
     * @param ids 主键.
     */
    @Override
    public void remove_(Collection<String> ids) {

        for (String id : ids) {
            this.remove(id);
        }
    }

    /**
     * 批量逻辑删除.
     *
     * @param ids 主键.
     * @return 信息.
     */
    @Override
    public ApiOutput<String> remove(Collection<String> ids) {

        this.remove_(ids);

        return ApiOutput.of("删除成功");

    }

    /**
     * 批量删除.
     *
     * @param ids 主键.
     */
    @Override
    public void delete_(Collection<String> ids) {

        for (String id : ids) {
            this.delete_(id);
        }

    }

    /**
     * 批量删除.
     *
     * @param ids 主键.
     * @return 信息.
     */
    @Override
    public ApiOutput<String> delete(Collection<String> ids) {

        this.delete_(ids);

        return ApiOutput.of("删除成功");

    }

    /**
     * 查询所有.
     *
     * @return 对象.
     */
    @Override
    public List<T> queryAll_() {

        return this.getRepository().findAll();

    }

    /**
     * 查询所有.
     *
     * @return 对象.
     */
    @Override
    public ApiOutput<List<T>> queryAll() {

        return ApiOutput.of(this.queryAll_());
    }
}
