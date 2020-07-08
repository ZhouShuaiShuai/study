package zhouyf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * @author Zhouyf
 * @Data 2020-06-15  10:16
 */
@SpringBootApplication
@EnableJpaAuditing
public class DataJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(DataJpaApplication.class,args);
    }

}
