package com.example.template;

import com.example.template.config.TempConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({TempConfig.class})
public class TempApplication {
    public static void main(String[] args) {
        SpringApplication.run(TempApplication.class, args);
    }
}