package zhouyf.pojo;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Zhouyf
 * @Data 2020-06-15  10:24
 * 班级
 */
@Table(name = "clazz")
@Entity
@Data
@EntityListeners(AuditingEntityListener.class)
public class Clazz {

    @Id
    @Column(length = 32, nullable = false)
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    private String id;

    @Column(length = 20)
    private String name;

    @LastModifiedDate
    private Date LastModifiedDate;

    @CreatedDate
    private Date createDate;

}
