package com.wolf89.wolf.core.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(value = RetentionPolicy.SOURCE)
@Target(value = {ElementType.METHOD, ElementType.FIELD})
public @interface EntityInfo {

    /**
     * 设置名称.
     *
     * @return
     */
    String name() default "";

    /**
     * 设置值.
     *
     * @return
     */
    String value() default "";

    /**
     * 描述.
     *
     * @return
     */
    String descript() default "";

    /**
     * 备注.
     *
     * @return
     */
    String note() default "";

    
}
