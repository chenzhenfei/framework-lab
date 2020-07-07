package com.tsshare.lab02;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@MapperScan(basePackages= "com.tsshare.lab02.repository")
@EnableCaching
public class Lab02Application {

    public static void main(String[] args) {
        SpringApplication.run(Lab02Application.class, args);
    }

}
