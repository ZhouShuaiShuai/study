package com.zhouyf.learn.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * @author Zhouyf
 * @Data 2020-07-28  14:31
 */
@Table(name = "user")
@Entity
@Data
public class User {
    @JsonIgnore
    @Id
    @Column(length = 32, nullable = false)
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    private String userId;

    @Column(length = 20)
    private String name;

    @Column(length = 20)
    private String username;

    @Column(length = 64)
    private String password;

    @Column(length = 2)
    private Boolean isUse;


}
