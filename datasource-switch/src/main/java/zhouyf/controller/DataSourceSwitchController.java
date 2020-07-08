package zhouyf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zhouyf.pojo.DatasourceSwitch;
import zhouyf.service.DataSourceSwitchService;

import java.util.List;

/**
 * @author Zhouyf
 * @Data 2020-06-13  19:20
 */
@RestController
@RequestMapping(value = "datasourceSwitch",produces = "application/json;charset=utf-8")
public class DataSourceSwitchController {

    @Autowired
    private DataSourceSwitchService dataSourceSwitchService;

    @GetMapping("findAll")
    public List<DatasourceSwitch> findAll(){
        return dataSourceSwitchService.findAll();
    }

    @GetMapping("findAll2")
    public List<DatasourceSwitch> findAll2(){
        return dataSourceSwitchService.findAll2();
    }

    @GetMapping("findAll3")
    public List<DatasourceSwitch> test(){
        return dataSourceSwitchService.findAll3();
    }


}
