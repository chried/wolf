package com.wolf89.wolf.cao.system;

import com.wolf89.wolf.model.cache.STokenCache;
import org.springframework.data.keyvalue.repository.KeyValueRepository;
import org.springframework.stereotype.Repository;

/**
 * dao.
 *
 * @author gaoweibing
 */
@Repository
public interface STokenCacheRepository extends KeyValueRepository<STokenCache, String> {
}
