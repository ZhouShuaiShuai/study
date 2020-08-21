package com.zhouyf.learn.repository;

import com.zhouyf.learn.pojo.UserAndRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Zhouyf
 * @Data 2020-07-28  15:09
 */
@Repository
public interface UserAndRoleRepository extends JpaRepository<UserAndRole,Integer> {

    void deleteAllByUserId(String userId);

    void deleteAllByUserIdAndRoleId(String userId, String roleId);

    @Query(value = "SELECT roleId FROM UserAndRole WHERE userId = ?1", nativeQuery = true)
    List<String> findRoleIdByUserId(String userId);

}
