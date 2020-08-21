package com.zhouyf.learn.repository;

import com.zhouyf.learn.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author Zhouyf
 * @Data 2020-08-13  9:39
 */
@Repository
public interface UserRepository extends JpaRepository<User, String> , JpaSpecificationExecutor<User> {

    User findByUsername(String username);

}
