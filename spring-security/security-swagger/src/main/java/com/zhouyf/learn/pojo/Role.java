package com.zhouyf.learn.pojo;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

/**
 * @author Zhouyf
 * @Data 2020-07-28  14:48
 */
@Table(name = "role")
@Entity
@Data
public class Role implements GrantedAuthority {

    @Id
    @Column(length = 32, nullable = false)
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    private String roleId;

    @Column(length = 20)
    private String roleName;    //角色名称

    @Column(length = 2)
    private Boolean isUse;

    @Override
    public String getAuthority() {
        return this.roleName;
    }
}
