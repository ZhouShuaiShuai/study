package zhouyf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zhouyf.dao.StudentDao;
import zhouyf.dao.TeacherDao;
import zhouyf.pojo.Student;

/**
 * @author Zhouyf
 * @Data 2020-06-15  11:14
 */
@Service
public class StudentService {

    @Autowired
    private StudentDao studentDao;

    public Student insert(Student student){
        return studentDao.save(student);
    }

}
