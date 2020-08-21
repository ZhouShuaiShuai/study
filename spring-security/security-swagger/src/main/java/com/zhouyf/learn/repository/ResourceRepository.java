package com.zhouyf.learn.repository;

import com.zhouyf.learn.pojo.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Zhouyf
 * @Data 2020-08-14  10:03
 */
@Repository
public interface ResourceRepository extends JpaRepository<Resource,Integer> , JpaSpecificationExecutor<Resource> {

    @Query(value = "select r.path from resource r " +
            "LEFT JOIN role_and_resource rr on r.resource_id = rr.resource_id " +
            "LEFT JOIN role ro on rr.role_id = ro.role_id " +
            "LEFT JOIN user_and_role ur on ro.role_id = ur.role_id " +
            "LEFT JOIN user u on ur.user_id = u.user_id " +
            "where u.user_id = ?1 and ro.is_use = true and r.is_use = true", nativeQuery = true)
    List<String> findPathByUserId(String userId);

    void deleteAllByResourceId(String[] resourceIds);
}
