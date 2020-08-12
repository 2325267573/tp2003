package cn.kgc.demo.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
//实现类的动态绑定
@MapperScan(basePackages = "cn.kgc.demo.demo.mapper")
//扫描service
@ComponentScan(basePackages = {"cn.kgc.demo.demo.service.impl","cn.kgc.demo.demo.constroller",})
@EnableTransactionManagement
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
