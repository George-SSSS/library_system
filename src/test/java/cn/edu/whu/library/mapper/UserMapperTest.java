package cn.edu.whu.library.mapper;

import cn.edu.whu.library.LibraryApplication;
import cn.edu.whu.library.modules.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest(classes = LibraryApplication.class)
class UserMapperTest {
    @Resource
    private UserMapper userMapper;

    @Test
    public void selectUser(){
        userMapper.selectList(null).stream().forEach(System.out::println);
    }
}