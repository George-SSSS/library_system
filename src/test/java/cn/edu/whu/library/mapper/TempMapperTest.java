package cn.edu.whu.library.mapper;

import cn.edu.whu.library.LibraryApplication;
import cn.edu.whu.library.modules.service.impl.TempServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest(classes = LibraryApplication.class)
public class TempMapperTest {
    @Resource
    private TempServiceImpl tempService;

    @Test
    public void selectUser() {
        tempService.findAllUser();
    }
}
