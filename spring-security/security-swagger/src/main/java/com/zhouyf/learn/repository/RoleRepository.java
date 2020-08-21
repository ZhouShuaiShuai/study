package com.zhouyf.learn.repository;

import com.zhouyf.learn.pojo.Role;
import com.zhouyf.learn.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Zhouyf
 * @Data 2020-07-28  15:05
 */
@Repository
public interface RoleRepository extends JpaRepository<Role,String> , JpaSpecificationExecutor<Role> {


    @Query(value = "select r.* from role r \n" +
            "left join user_and_role ur on r.role_id = ur.role_id \n" +
            "left join `user` u on ur.user_id = u.user_id \n" +
            "where u.user_id = '1' and r.is_use = 1 and u.is_use = ?1", nativeQuery = true)
    List<Role> findRolesByUserId(String userId);

}
