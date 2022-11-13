package com.example.template.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "temp")
public class TempConfig {
    private String attr1;

    private String attr2;

    private String attr3;

    private String attr4;

//    public Template tempClient() {
//        return new TempClientBuilder().build(attr1, attr2, attr3, attr4);
//    }
}
