package com.example.template.modules.temp.controller;

import com.example.template.config.RSAConfig;
import com.example.template.config.TempConfig;
import com.example.template.modules.temp.entity.TempEntity;
import com.example.template.modules.temp.service.ITempService;
import com.example.template.common.utils.RSAUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/test")
public class TempController {

    @Value("${server.port}")
    String port;

    @Value("${rsa.key-size}")
    String keySize;

    @Value("${rsa.public-key-file}")
    String publicKeyFile;

    @Autowired
    RSAConfig rsaConfig;

    @Autowired
    TempConfig tempConfig;

    @Autowired
    private ITempService tempService;

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
        String plain = "Sonya is a 啊兹卡西 Imōto pig";
        String encryptedStr = RSAUtil.encrypt(plain, new File(rsaConfig.getPublicKeyFile()));
        System.out.println(encryptedStr);
        String decryptedStr = RSAUtil.decrypt(encryptedStr, new File(rsaConfig.getPrivateKeyFile()));
        System.out.println(decryptedStr);
        return decryptedStr + "<br/>" + port + "<br/>" + keySize + "<br/>" + tempConfig.getAttr1();
    }

    @RequestMapping("/findAllUser")
    public List<TempEntity> findAll() {
        System.out.println("aaa");
        return tempService.findAllUser();
    }

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @RequestMapping("/mysqlTest")
    public Map<String, Object> map() {
        List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from temp_entity");
        return list.get(0);
    }

    @RequestMapping("outputAllBean")
    public void outputAllBean() {

    }
}
