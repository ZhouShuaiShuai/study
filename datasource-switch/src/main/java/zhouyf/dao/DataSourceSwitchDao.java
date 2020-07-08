package zhouyf.dao;

import org.springframework.stereotype.Repository;
import zhouyf.datasource.CurDataSource;
import zhouyf.pojo.DatasourceSwitch;

import java.util.List;

/**
 * @author Zhouyf
 * @Data 2020-06-13  19:26
 */
@Repository
public interface DataSourceSwitchDao{

    @CurDataSource("one")
    List<DatasourceSwitch> findAll();

    @CurDataSource("two")
    List<DatasourceSwitch> findAll2();

    @CurDataSource("three")
    List<DatasourceSwitch> findAll3();

}
