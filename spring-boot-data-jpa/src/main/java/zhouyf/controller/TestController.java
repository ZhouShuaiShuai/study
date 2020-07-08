package zhouyf.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zhouyf.pojo.Clazz;
import zhouyf.pojo.Student;
import zhouyf.pojo.Teacher;
import zhouyf.service.ClazzService;
import zhouyf.service.StudentService;
import zhouyf.service.TeacherService;

import java.util.List;

/**
 * @author Zhouyf
 * @Data 2020-06-15  10:59
 */
@RestController
@RequestMapping(value = "test",produces = "application/json;charset=utf-8")
@Api(tags = {"测试相关接口"})
public class TestController {

    @Autowired
    private ClazzService clazzService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private StudentService studentService;

    @GetMapping("addTeacher")
    @ApiOperation(value = "添加老师信息")
    public Teacher addTeacher(String teacherName){
        Teacher teacher = new Teacher();
        teacher.setName(teacherName);
        return teacherService.insert(teacher);
    }

    @GetMapping("addClazz")
    @ApiOperation(value = "添加班级信息")
    public Clazz addClazz(String clazzName){
        Clazz clazz = new Clazz();
        clazz.setName(clazzName);
        return clazzService.insert(clazz);
    }

    @GetMapping("findAllTeacher")
    public List<Teacher> findAllTeacher(){
        return teacherService.findAll();
    }

}
