package com.zhouyf.learn.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

/**
 * @author Zhouyf
 * @Data 2020-07-28  14:51
 */
@Table(name = "resource")
@Entity
@Data
public class Resource {

    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer resourceId;
    @Column(length = 200)
    private String path;
    @Column(length = 50)
    private String description;
    @Column(length = 2)
    private Boolean isUse;

}
