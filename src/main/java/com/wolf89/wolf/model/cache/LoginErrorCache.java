package com.wolf89.wolf.model.cache;

import com.wolf89.wolf.core.annotation.CacheInfo;
import com.wolf89.wolf.core.cache.AbstractCache;
import org.springframework.data.redis.core.RedisHash;

/**
 * 登陆错误消息.
 *
 * @author chried
 */
@RedisHash(value = "wsystem.LoginErrorCache")
public class LoginErrorCache extends AbstractCache {

    @CacheInfo(name = "用户id", value = "userId")
    private String userId;

    @CacheInfo(name = "错误次数", value = "error")
    private int error;

    /**
     * Gets the value of userId.
     *
     * @return the value of userId.
     */
    public String getUserId() {
        return userId;
    }

    /**
     * Sets the userId.
     * <p>You can use getUserId() to get the value of userId.</p>
     *
     * @param userId userId.
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * Gets the value of error.
     *
     * @return the value of error.
     */
    public int getError() {
        return error;
    }

    /**
     * Sets the error.
     * <p>You can use getError() to get the value of error.</p>
     *
     * @param error error.
     */
    public void setError(int error) {
        this.error = error;
    }
}
