package com.cdtu.salesplatform;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by Administrator on 2018/3/11.
 */
@SpringBootApplication
@MapperScan("com.cdtu.salesplatform.dao")
@ComponentScan({"com.cdtu.salesplatform.controller","com.cdtu.salesplatform.service"})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
