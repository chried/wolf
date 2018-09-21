package com.wolf89.wolf.model.cache;

import com.wolf89.wolf.core.annotation.CacheInfo;
import com.wolf89.wolf.core.cache.AbstractCache;
import org.springframework.data.redis.core.RedisHash;

import java.time.LocalDateTime;

/**
 * token缓存.
 *
 * @author gaoweibing
 */
@RedisHash(value = "wsystem.STokenCache")
public class STokenCache extends AbstractCache {

    /**
     * 令牌.
     */
    @CacheInfo(name = "令牌", value = "token")
    private String token;

    /**
     * 过期时间.
     */
    @CacheInfo(name = "过期时间", value = "expire")
    private LocalDateTime expire;

    /**
     * Gets the value of token.
     *
     * @return the value of token.
     */
    public String getToken() {
        return token;
    }

    /**
     * Sets the token.
     * <p>You can use getToken() to get the value of token.</p>
     *
     * @param token token.
     */
    public void setToken(String token) {
        this.token = token;
    }

    /**
     * Gets the value of expire.
     *
     * @return the value of expire.
     */
    public LocalDateTime getExpire() {
        return expire;
    }

    /**
     * Sets the expire.
     * <p>You can use getExpire() to get the value of expire.</p>
     *
     * @param expire expire.
     */
    public void setExpire(LocalDateTime expire) {
        this.expire = expire;
    }
}
