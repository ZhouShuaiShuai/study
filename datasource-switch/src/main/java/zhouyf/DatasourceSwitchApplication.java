package zhouyf;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author Zhouyf
 * @Data 2020-05-29  15:41
 */
@SpringBootApplication
@MapperScan("zhouyf.dao")
public class DatasourceSwitchApplication {
    public static void main(String[] args) {
        SpringApplication.run(DatasourceSwitchApplication.class,args);
    }
}
