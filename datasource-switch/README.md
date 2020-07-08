# Spring Boot中多数据源切换说明
> 运行版本
- spring boot 2.2.5.RELEASE
- 数据源使用spring boot自带的Hikari
- 数据库连接 mybatis plus
> 不支持事务
---

##运行说明
1.创建[CurDataSource](.\src\main\java\zhouyf\datasource\CurDataSource.java)注解  
2.创建[DBproperties](.\src\main\java\zhouyf\datasource\DBproperties.java)类获取配置文件中配置的数据源连接  
3.创建[DynamicDataSource](.\src\main\java\zhouyf\datasource\DynamicDataSource.java)类继承AbstractRoutingDataSource抽象类，重写determineCurrentLookupKey() 方法（AbstractRoutingDataSource 根据用户定义的规则选择当前的数据源，这样我们可以在执行查询之前，设置使用的数据源。）  
4.创建[DynamicDataSourceConfig](.\src\main\java\zhouyf\datasource\DynamicDataSourceConfig.java)类使DBproperties获取的数据源配置到DynamicDataSource中  
5.创建AOP拦截器[DataSourceAspect](.\src\main\java\zhouyf\datasource\DataSourceAspect.java)，拦截CurDataSource注解，并根据注解上的value值来动态的切换数据源  
**详情可参考具体类实现**

---
> spring boot data jpa 使用注意事项 
- 如果 jpa.hibernate.ddl-auto为update或great则会在默认的数据源上创建或修改表结构
- 可以返回同一实体类（如果数据源2和数据源1同时都有一张表的情况下，会去切换的数据源下找）
- 可以证明表和实体类并没有绑定数据源
- 如果需要了解更多请去spring boot data jpa 模块中查询
