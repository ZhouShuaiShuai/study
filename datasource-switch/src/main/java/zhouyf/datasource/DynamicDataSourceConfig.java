package zhouyf.datasource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Zhouyf
 * @Data 2020-05-29  11:23
 * 注册多个数据源信息
 */
@Configuration
public class DynamicDataSourceConfig {

    @Autowired
    private DBproperties properties;

    @Bean
    @Primary
    public DynamicDataSource dataSource() {
        Map targetDataSources =new HashMap<>();
        targetDataSources.put("one", properties.getOne());
        targetDataSources.put("two", properties.getTwo());
        targetDataSources.put("three", properties.getThree());
        return new DynamicDataSource(properties.getOne(),targetDataSources);
    }

}
