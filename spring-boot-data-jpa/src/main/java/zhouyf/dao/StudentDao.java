package zhouyf.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import zhouyf.pojo.Student;

/**
 * @author Zhouyf
 * @Data 2020-06-15  11:10
 */
@Repository
public interface StudentDao extends JpaRepository<Student,String> {
}
