package com;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //组合注解，用于快捷配置启动类
@MapperScan(basePackages = {"com.dao"}) //Springboot启动类上面添加@MapperScan注解，就指定mapper接口所在的包，然后包下面的所有接口在编译之后都会生成相应的实现类
public class SpringbootSchemaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootSchemaApplication.class, args);
    }

}
