package cn.edu.whu.library.modules.service;

import cn.edu.whu.library.LibraryApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest(classes = LibraryApplication.class)
public class AuthorServiceTest {

    @Autowired
    private AuthorService authorService;

    @Test
    public void findAuthorListById() {
        String authorIdList = new String("1, 2, 3,5");

        String authorList = authorService.findAuthorListById(authorIdList);

        System.out.println(authorList);
    }
}
