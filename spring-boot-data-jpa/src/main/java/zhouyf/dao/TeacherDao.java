package zhouyf.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import zhouyf.pojo.Teacher;

/**
 * @author Zhouyf
 * @Data 2020-06-15  11:02
 */
@Repository
public interface TeacherDao extends JpaRepository<Teacher,String> {
}
