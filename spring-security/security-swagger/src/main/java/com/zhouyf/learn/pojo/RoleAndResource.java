package com.zhouyf.learn.pojo;

import lombok.Data;

import javax.persistence.*;

/**
 * @author Zhouyf
 * @Data 2020-07-28  15:03
 * 角色和资源关联表
 */
@Table(name = "role_and_resource")
@Entity
@Data
public class RoleAndResource {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 32)
    private String roleId;
    @Column(length = 32)
    private Integer resourceId;

    public RoleAndResource(){}

    public RoleAndResource(String roleId,Integer resourceId){
        this.roleId = roleId;
        this.resourceId = resourceId;
    }

}
