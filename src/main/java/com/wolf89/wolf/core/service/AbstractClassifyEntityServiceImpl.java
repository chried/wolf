package com.wolf89.wolf.core.service;

import com.wolf89.wolf.core.dao.AbstractClassifyEntityRepository;
import com.wolf89.wolf.core.entity.Refer;
import com.wolf89.wolf.core.output.ApiOutput;
import com.wolf89.wolf.core.entity.AbstractClassifyEntity;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ValidationException;
import java.util.ArrayList;
import java.util.List;

/**
 * 分类service父级实现.
 *
 * @param <T>
 * @author chried
 */
public abstract class AbstractClassifyEntityServiceImpl<T extends AbstractClassifyEntity> extends AbstractEntityServiceImpl<T> implements AbstractClassifyEntityService<T> {

    @Override
    public abstract AbstractClassifyEntityRepository<T> getRepository();

    @Override
    public ApiOutput<List<Refer>> selection() {
        List<Refer> result = new ArrayList<>();

        List<T> list = this.queryAll_();

        list.forEach((t) -> {
            result.add(t.toRefer());
        });

        return ApiOutput.of(result);
    }

    @Override
    public ApiOutput<List<Refer>> selectionByLead(String lead) {
        List<Refer> result = new ArrayList<>();

        List<T> list = this.queryByLead_(lead, true);

        list.forEach((t) -> {
            result.add(t.toRefer());
        });

        return ApiOutput.of(result);
    }

    @Override
    public ApiOutput<List<Refer>> selection(String keyword) {
        List<Refer> result = new ArrayList<>();

        List<T> list = this.queryByLead_("", true, keyword);

        list.forEach((t) -> {
            result.add(t.toRefer());
        });

        return ApiOutput.of(result);
    }

    @Override
    public ApiOutput<List<Refer>> selectionByLead(String lead, String keyword) {
        List<Refer> result = new ArrayList<>();

        List<T> list = this.queryByLead_(lead, true, keyword);

        list.forEach((t) -> {
            result.add(t.toRefer());
        });

        return ApiOutput.of(result);
    }

    @Override
    public ApiOutput<List<T>> queryByLead(String lead, boolean visible) {
        return ApiOutput.of(this.queryByLead_(lead, visible));
    }

    @Override
    public List<T> queryByLead_(String lead, boolean visible) {
        return this.getRepository().queryByLead_(lead, visible);
    }

    @Override
    public List<T> queryByLead_(String lead, boolean visible, String keyword) {
        return this.getRepository().queryByLead_(lead, visible, keyword);
    }


    @Override
    public ApiOutput<String> validatorByCode(String id, String code) {

        T t = this.findByCode_(code);

        if (StringUtils.isBlank(id)) {
            if (t != null) {
                throw new ValidationException("代码已被占用!");
            }
        } else {
            if (t != null && (!StringUtils.equalsIgnoreCase(id, t.getId()))) {
                throw new ValidationException("代码已被占用!");
            }
        }

        return ApiOutput.of("验证通过");
    }

    @Override
    public ApiOutput<T> findByCode(String code) {
        T result = this.findByCode_(code);

        if (result == null) {
            throw new ValidationException("没有找到对应数据");
        }

        return ApiOutput.of(result);
    }

    @Override
    public T findByCode_(String code) {
        return this.getRepository().findByCode_(code);
    }

    @Override
    public ApiOutput<String> validatorByName(String id, String lead, String name) {

        T t = this.findByName_(lead, name);

        if (StringUtils.isBlank(id)) {
            if (t != null) {
                throw new ValidationException("名字已被占用!");
            }
        } else {
            if (t != null && (!StringUtils.equalsIgnoreCase(id, t.getId()))) {
                throw new ValidationException("名字已被占用!");
            }
        }

        return ApiOutput.of("验证通过");
    }

    @Override
    public ApiOutput<T> findByName(String lead, String name) {
        return ApiOutput.of(this.findByName_(lead, name));
    }

    @Override
    public T findByName_(String lead, String name) {
        return this.getRepository().findByName_(lead, name);
    }


}
