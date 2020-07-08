package zhouyf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zhouyf.dao.DataSourceSwitchDao;
import zhouyf.datasource.CurDataSource;
import zhouyf.pojo.DatasourceSwitch;

import java.util.List;

/**
 * @author Zhouyf
 * @Data 2020-06-13  19:25
 */
@Service
public class DataSourceSwitchService {

    @Autowired
    private DataSourceSwitchDao dataSourceSwitchDao;

    public List<DatasourceSwitch> findAll(){
        return dataSourceSwitchDao.findAll();
    }

    public List<DatasourceSwitch> findAll2(){
        return dataSourceSwitchDao.findAll2();
    }

    public List<DatasourceSwitch> findAll3(){
        return dataSourceSwitchDao.findAll3();
    }


}
