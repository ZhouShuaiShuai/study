package zhouyf.pojo;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * @author Zhouyf
 * @Data 2020-06-15  10:23
 * 学生
 */
@Table(name = "student")
@Entity
@Data
public class Student {

    @Id
    @Column(length = 32, nullable = false)
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    private String id;

    @Column(length = 20)
    private String name;

    @Column(length = 32)
    private String clazzId;

    @Column(length = 2)
    private Integer age;

}
