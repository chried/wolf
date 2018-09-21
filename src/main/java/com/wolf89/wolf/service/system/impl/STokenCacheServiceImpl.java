package com.wolf89.wolf.service.system.impl;

import com.wolf89.wolf.cao.system.STokenCacheRepository;
import com.wolf89.wolf.model.cache.STokenCache;
import com.wolf89.wolf.model.entity.system.STokenEntity;
import com.wolf89.wolf.service.system.STokenCacheService;
import com.wolf89.wolf.service.system.STokenEntityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * service实现.
 *
 * @author gaoweibing
 */
@Service
public class STokenCacheServiceImpl implements STokenCacheService {

    private static final Logger LOG = LoggerFactory.getLogger(STokenCacheServiceImpl.class);

    @Autowired
    private STokenCacheRepository sTokenCacheRepository;

    @Autowired
    private STokenEntityService sTokenEntityService;

    /**
     * 验证token是否过期.
     *
     * @param token token.
     * @return true过期, false没有.
     */
    @Override
    public boolean validateToken(String token) {

        // 获取redis token.
        STokenCache sTokenCache = sTokenCacheRepository.findById(token).orElse(null);

        LocalDateTime now = LocalDateTime.now();

        // 说明没有token，表示未登录.
        if (sTokenCache == null) {
            return true;
        }

        // 过期时间在当前时间之前，说明过期.
        if (sTokenCache.getExpire().isBefore(now)) {
            return true;
        }

        // 如果token还有三分钟过期，同时是活动token,那么刷新token.
        if (now.minusMinutes(3).isAfter(sTokenCache.getExpire())) {
            sTokenCache.setExpire(now.plusMinutes(33));

            STokenEntity sTokenEntity = this.sTokenEntityService.findByToken(token);

            // 如果数据库不存在，可能是不正确的token.
            if (sTokenEntity == null) {
                return true;
            }

            sTokenEntity.setExpire(now.plusMinutes(33));

            this.sTokenEntityService.save(sTokenEntity);

        }

        return false;

    }
}
