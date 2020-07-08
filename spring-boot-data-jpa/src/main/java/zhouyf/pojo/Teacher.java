package zhouyf.pojo;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * @author Zhouyf
 * @Data 2020-06-15  10:18
 * 老师
 */
@Table(name = "teacher")
@Entity
@Data
public class Teacher {

    @Id
    @Column(length = 32, nullable = false)
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    private String id;

    @Column(length = 20)
    private String name;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH},fetch = FetchType.LAZY)
    @JoinColumn(name="clazzId")
    private Clazz clazz;

}
