package com.wolf89.wolf.cao.system;

import com.wolf89.wolf.model.cache.LoginErrorCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.PartialUpdate;
import org.springframework.data.redis.core.RedisKeyValueAdapter;
import org.springframework.data.redis.core.RedisKeyValueTemplate;

/**
 * dao实现.
 *
 * @author chried
 */
public class LoginErrorCacheRepositoryImpl {

    private static final Logger LOG = LoggerFactory.getLogger(LoginErrorCacheRepositoryImpl.class);

    @Autowired
    private RedisKeyValueTemplate redisKeyValueTemplate;

    /**
     * 根据userId获取.
     *
     * @param userId 用户id.
     * @return 错误信息.
     */
    public LoginErrorCache findByUserId(String userId) {

      /*  LOG.info("根据userId获取,userId=[{}]", userId);

        return redisKeyValueTemplate.execute(adapter -> {

            RedisKeyValueAdapter redisKeyValueAdapter = (RedisKeyValueAdapter) adapter;

            return redisKeyValueAdapter.get("userId", userId, LoginErrorCache.class);
        });
*/

        PartialUpdate<LoginErrorCache> partialUpdate=new PartialUpdate(userId,LoginErrorCache.class);
    }
}
