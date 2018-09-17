package com.wolf89.wolf.core.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 缓存类注解.
 *
 * @author gaoweibing
 */
@Retention(value = RetentionPolicy.SOURCE)
@Target(value = {ElementType.METHOD, ElementType.FIELD})
public @interface CacheInfo {

    /**
     * 名称.
     *
     * @return
     */
    String name() default "";

    /**
     * 值.
     *
     * @return
     */
    String value() default "";
}
