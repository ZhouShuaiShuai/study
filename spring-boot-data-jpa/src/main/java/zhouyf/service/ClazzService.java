package zhouyf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import zhouyf.dao.ClazzDao;
import zhouyf.dao.TeacherDao;
import zhouyf.pojo.Clazz;

import java.util.List;

/**
 * @author Zhouyf
 * @Data 2020-06-15  11:14
 */
@Service
public class ClazzService {

    @Autowired
    private ClazzDao clazzDao;

    public List<Clazz> findAll(){
        return clazzDao.findAll();
    }

    public Clazz insert(Clazz clazz){
        return clazzDao.save(clazz);
    }

    public void delete(String id){
        clazzDao.deleteById(id);
    }

}
