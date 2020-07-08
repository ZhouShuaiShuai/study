package zhouyf.datasource;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Slf4j
@Aspect
@Component
public class DataSourceAspect implements Ordered {
    @Pointcut("@annotation(zhouyf.datasource.CurDataSource)")
    public void dataSourcePointCut() {}

    @Around("dataSourcePointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        CurDataSource ds = method.getAnnotation(CurDataSource.class);
        if (ds == null) {
            DynamicDataSource.setDataSource("one");
            log.warn("----数据源使用----- 当前数据源为：one");
        } else {
            DynamicDataSource.setDataSource(ds.value());
            log.warn("----数据源使用----- 当前数据源为："+ds.value());
        }
        try {
            return point.proceed();
        } finally {
            DynamicDataSource.clearDataSource();
        }
    }

    @Override
    public int getOrder() {
        return 1;
    }
}