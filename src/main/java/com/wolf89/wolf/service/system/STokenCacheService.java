package com.wolf89.wolf.service.system;

/**
 * service.
 *
 * @author gaoweibing
 */
public interface STokenCacheService {

    /**
     * 验证token是否过期.
     *
     * @param token token.
     * @return true过期, false没有.
     */
    boolean validateToken(String token);
}
