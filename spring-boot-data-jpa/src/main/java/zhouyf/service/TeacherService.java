package zhouyf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zhouyf.dao.TeacherDao;
import zhouyf.pojo.Teacher;

import java.util.List;

/**
 * @author Zhouyf
 * @Data 2020-06-15  11:14
 */
@Service
public class TeacherService {

    @Autowired
    private TeacherDao teacherDao;

    public List<Teacher> findAll(){
        return teacherDao.findAll();
    }

    public Teacher insert(Teacher teacher){
        return teacherDao.save(teacher);
    }
}
