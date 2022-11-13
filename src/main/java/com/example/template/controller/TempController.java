package com.example.template.controller;

import com.example.template.config.RSAConfig;
import com.example.template.service.TempService;
import com.example.template.utils.RSAUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;

@RestController
@RequestMapping("/test")
public class TempController {

    @Autowired
    RSAConfig rsaConfig;

    @Autowired
    private TempService tempService;

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/upload")
    public String upload() {
        return tempService.serviceMethod();
    }

    @RequestMapping("/genRSAPair")
    public String genRSAPair() {
//        return RSAUtil.genKeyPair();
        String plain = "Sonya is a 啊兹卡西 Imōto pig";
        String encryptedStr = RSAUtil.encrypt(plain, new File(rsaConfig.getPublicKeyFile()));
        System.out.println(encryptedStr);
        String decryptedStr = RSAUtil.decrypt(encryptedStr, new File(rsaConfig.getPrivateKeyFile()));
        System.out.println(decryptedStr);
        return decryptedStr;
    }
}
