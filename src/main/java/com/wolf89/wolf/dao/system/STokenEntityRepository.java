package com.wolf89.wolf.dao.system;

import com.wolf89.wolf.core.dao.AbstractEntityRepository;
import com.wolf89.wolf.model.entity.system.STokenEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * dao.
 *
 * @author gaoweibing
 */
@Repository
public interface STokenEntityRepository extends AbstractEntityRepository<STokenEntity> {

    /**
     * 获取token.
     *
     * @param token token.
     * @return token.
     */
    @Query("SELECT T FROM STokenEntity  T WHERE T.token = :token" +
            " AND T.status_ = :status_")
    STokenEntity findByToken(@Param("token") String token, @Param("status_") String status_);
}
