package com.example.template.mapper;

import com.example.template.TempApplication;
import com.example.template.modules.temp.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest(classes = TempApplication.class)
class UserMapperTest {
    @Resource
    private UserMapper userMapper;

    @Test
    public void selectUser(){
        userMapper.selectList(null).stream().forEach(System.out::println);
    }
}