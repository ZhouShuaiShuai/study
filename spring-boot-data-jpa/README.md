# Spring Data Jpa使用说明
> 运行版本
- spring data jpa 2.2.5.RELEASE
- *[官方文档](https://docs.spring.io/spring-data/jpa/docs/2.2.5.RELEASE/reference/html/#)*
---
*Repository继承关系*  
> `Repository` 为spring data jpa 的中央接口
>> `CrudRepository` 提供最基本的增删改查
>>> `PagingAndSortingRepository` 它添加了其他方法来简化对实体的分页访问
>>>> `JpaRepository` 封装了完整的方法
---
## 注解查询`@Query`的使用
- 可以自定义查询语句
```
public interface UserRepository extends JpaRepository<User, Long> {
  # 其中的User表示实体类名称
  @Query("select u from User u where u.firstname like %?1")
  List<User> findByFirstnameEndsWith(String firstname);
}
```

- 使用原生态的本地查询（也就是直接用sql语句查询）
```
public interface UserRepository extends JpaRepository<User, Long> {
  # 其中的USER就直接代表数据库中的表名
  @Query(value = "SELECT * FROM USERS WHERE EMAIL_ADDRESS = ?1", nativeQuery = true)
  User findByEmailAddress(String emailAddress);
}
```

- 使用分页查询
```
public interface UserRepository extends JpaRepository<User, Long> {
  # 第一个查询数据，第二个查询总条数
  @Query(value = "SELECT * FROM USERS WHERE LASTNAME = ?1",
    countQuery = "SELECT count(*) FROM USERS WHERE LASTNAME = ?1",
    nativeQuery = true)
  Page<User> findByLastname(String lastname, Pageable pageable);
}
```

- 使用命名参数
```
public interface UserRepository extends JpaRepository<User, Long> {
  # 不是?1 而是使用：参数名代替
  @Query("select u from User u where u.firstname = :firstname or u.lastname = :lastname")
  User findByLastnameOrFirstname(@Param("lastname") String lastname,
                                 @Param("firstname") String firstname);
}
```

- 对数据库进行删除或修改操作时需要添加 `@Modifying`注解
---  
>在一对多或多对一的关系处理中可以使用`@ManyToOne`、`@ManyToMany`、`@OneToMany`  但是不建议这样，建议直接在表中设置外键关联如：`userId`、`roleId`、`teacherId`这样做的关联关系后期更容易维护，但还是说明这三个注解的使用   
- *[参考文档](https://www.objectdb.com/api/java/jpa/ManyToOne)*
- caseCode选择级联操作，以数组的形式 
ALL(所有), PERSIST(保存), MERGE(合并), REMOVE(删除), REFRESH(更新), DETACH(分离)
```
public class Teacher {
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    private Clazz clazz;
}
```
- fetch是否为延迟加载
EAGER(非延迟),LAZY(延迟)



---
> 资料文档
- [在jpa查询中受支持的关键字](.\src\main\resources\file\jpa查询.png)