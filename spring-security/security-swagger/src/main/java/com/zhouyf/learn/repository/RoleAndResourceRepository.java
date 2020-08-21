package com.zhouyf.learn.repository;

import com.zhouyf.learn.pojo.RoleAndResource;
import io.swagger.models.auth.In;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Zhouyf
 * @Data 2020-08-19  10:54
 */
@Repository
public interface RoleAndResourceRepository extends JpaRepository<RoleAndResource, Integer> {

    @Query(value = "SELECT role_id FROM role_and_resource WHERE resource_id = ?1", nativeQuery = true)
    List<String> findRoleIdsByResourceId(Integer resourceId);

    void deleteAllByRoleId(String roleId);

}
