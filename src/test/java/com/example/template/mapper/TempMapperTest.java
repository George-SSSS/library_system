package com.example.template.mapper;

import com.example.template.TempApplication;
import com.example.template.modules.temp.mapper.TempMapper;
import com.example.template.modules.temp.service.impl.TempServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest(classes = TempApplication.class)
public class TempMapperTest {
    @Resource
    private TempServiceImpl tempService;

    @Test
    public void selectUser() {
        tempService.findAllUser();
    }
}
