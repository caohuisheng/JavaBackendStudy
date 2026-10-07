package com.itheima.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;

/*
配置类
 */
@Configuration
@ComponentScan("com.itheima")
@PropertySource(value = "classpath:jdbc.properties")
@Import(value = {JdbcConfig.class, MyBatisConfig.class})
//@EnableAspectJAutoProxy
//开启注解式事务驱动
//@EnableTransactionManagement
public class SpringConfig {

    // @Bean
    // public DataSource dataSource(){
    //     DruidDataSource ds = new DruidDataSource();
    //     ds.setDriverClassName("com.mysql.jdbc.Driver");
    //     ds.setUrl("jdbc://localhost:8080/itheima");
    //     ds.setUsername("root");
    //     ds.setPassword("123456");
    //     return ds;
    // }

}
