package com.example.template;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;


@MapperScan("com.example.template.**.mapper")
@SpringBootApplication
@EnableConfigurationProperties
public class TempApplication {
    public static void main(String[] args) {
        SpringApplication.run(TempApplication.class, args);
    }
}