package zhouyf.datasource;

import java.lang.annotation.*;

/**
 * @author Zhouyf
 * @Data 2020-05-29  11:05
 *
 * 指定要使用的数据源
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CurDataSource {

    String value() default "";

}
