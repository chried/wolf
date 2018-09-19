package com.wolf89.wolf.cao.system;

import com.wolf89.wolf.model.cache.LoginErrorCache;
import org.springframework.data.keyvalue.repository.KeyValueRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 登录错误缓存dao.
 *
 * @author gaoweibing
 */
@Repository
public interface LoginErrorCacheRepository extends KeyValueRepository<LoginErrorCache, String> {

    /**
     * 根据userId获取.
     *
     * @param userId 用户id.
     * @return 错误信息.
     */
    LoginErrorCache findByUserId(String userId);
}
