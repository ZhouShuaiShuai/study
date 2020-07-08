package zhouyf.datasource;

import com.zaxxer.hikari.HikariDataSource;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author Zhouyf
 * @Data 2020-05-29  11:43
 */
@Component
@Data
@ConfigurationProperties(prefix ="spring.datasource")
@EnableConfigurationProperties
public class DBproperties {

    private HikariDataSource one;

    private HikariDataSource two;

    private HikariDataSource three;

}
