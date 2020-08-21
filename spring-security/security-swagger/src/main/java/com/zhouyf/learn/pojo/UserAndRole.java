package com.zhouyf.learn.pojo;

import lombok.Data;

import javax.persistence.*;

/**
 * @author Zhouyf
 * @Data 2020-07-28  15:01
 * 用户和角色关联表
 */
@Table(name = "user_and_role")
@Entity
@Data
public class UserAndRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 32,nullable = false)
    private String userId;
    @Column(length = 32,nullable = false)
    private String roleId;

    public UserAndRole(){}

    public UserAndRole(String userId,String roleId){
        this.userId = userId;
        this.roleId = roleId;
    }

}
