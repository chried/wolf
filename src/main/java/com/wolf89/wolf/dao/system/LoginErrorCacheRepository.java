package com.wolf89.wolf.dao.system;

import com.wolf89.wolf.model.cache.LoginErrorCache;
import org.springframework.data.keyvalue.repository.KeyValueRepository;

/**
 * 登录错误缓存dao.
 *
 * @author gaoweibing
 */
public interface LoginErrorCacheRepository extends KeyValueRepository<LoginErrorCache, String> {
}
