package com.wolf89.wolf.core.dao;

import com.wolf89.wolf.core.cache.AbstractCache;
import org.springframework.data.keyvalue.repository.KeyValueRepository;

/**
 * 定义缓存父级.
 *
 * @param <T>
 * @author gaoweibing
 */
public interface AbstractCacheRepository<T extends AbstractCache> extends KeyValueRepository<T, String> {
}
