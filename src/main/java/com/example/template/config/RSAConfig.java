package com.example.template.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "rsa")
public class RSAConfig {
    // 存放公钥的文件路径
    private String publicKeyFile;
    // 存放私钥的文件路径
    private String privateKeyFile;
}
