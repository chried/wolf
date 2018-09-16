package com.wolf89.wolf.core.controller;

import com.wolf89.wolf.core.entity.AbstractEntity;
import com.wolf89.wolf.core.output.ApiOutput;
import com.wolf89.wolf.core.service.AbstractEntityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 实体类控制器.
 *
 * <pre>
 *     实现基本crud.
 * </pre>
 *
 * @param <T>
 * @author chried
 */
public abstract class AbstractEntityController<T extends AbstractEntity> extends AbstractController {

    private static final Logger LOG = LoggerFactory.getLogger(AbstractEntityController.class);

    public abstract AbstractEntityService getService();

    /**
     * 保存.
     *
     * @param t      对象.
     * @param result 验证.
     * @return 对象.
     */
    @PostMapping(value = "save")
    public ApiOutput<T> save(@RequestBody @Validated T t, BindingResult result) {

        LOG.info("保存对象");

        return this.getService().save(t);
    }

    /**
     * 获取.
     *
     * @param id 主键.
     * @return 对象.
     */
    @GetMapping(value = "get")
    public ApiOutput<T> get(@RequestParam(name = "id") String id) {

        LOG.info("获取对象,id=[{}]", id);

        return this.getService().get(id);
    }

    /**
     * 获取.
     *
     * @param id 主键.
     * @return 对象.
     */
    @GetMapping(value = "getOfEdit")
    public ApiOutput<T> getOfEdit(@RequestParam(name = "id", required = false) String id) {

        LOG.info("获取对象,id=[{}]", id);

        return this.getService().getOfEdit(id);

    }

    /**
     * 删除.
     *
     * @param id 主键id.
     * @return 信息.
     */
    @PostMapping(value = "delete")
    public ApiOutput<String> delete(@RequestParam(name = "id") String id) {

        LOG.info("删除,id=[{}]", id);

        return this.getService().delete(id);
    }

    /**
     * 逻辑删除.
     *
     * @param id
     * @return
     */
    @PostMapping(value = "remove")
    public ApiOutput<String> remove(@RequestParam(name = "id") String id) {

        LOG.info("删除,id=[{}]", id);

        return this.getService().remove(id);

    }
}
