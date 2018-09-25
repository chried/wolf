package com.wolf89.wolf.dao.user;

import com.wolf89.wolf.core.dao.AbstractEntityRepository;
import com.wolf89.wolf.model.entity.user.URoleEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * dao.
 *
 * @author gaoweibing
 */
@Repository
public interface URoleEntityRepository extends AbstractEntityRepository<URoleEntity> {

    /**
     * 根据用户id获取.
     *
     * @param userId 用户id.
     * @return 角色.
     */
    @Query("SELECT R FROM URoleEntity R ,UUserRoleEntity U WHERE " +
            " R.id = U.roleId " +
            " AND U.userId = :userId " +
            " AND R.status_ = :status_ " +
            " AND U.status_ = :status_" +
            " AND U.end >= :now")
    List<URoleEntity> queryByUserId(@Param("userId") String userId, @Param("now") LocalDateTime now, @Param("status_") String status_);
}
