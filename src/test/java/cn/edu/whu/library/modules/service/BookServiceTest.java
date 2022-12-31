package cn.edu.whu.library.modules.service;

import cn.edu.whu.library.LibraryApplication;
import cn.edu.whu.library.modules.mapper.BookMapper;
import cn.edu.whu.library.modules.vo.DocumentVo;
import com.alibaba.fastjson2.JSON;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@SpringBootTest(classes = LibraryApplication.class)
public class BookServiceTest {
    @Autowired
    private BookService bookService;

    @Autowired
    private BookMapper bookMapper;

    @Test
    public void findBookInfoByDocId() {
        List<Integer> documentIds = new ArrayList<>();
        documentIds.add(1);
        documentIds.add(2);
        documentIds.add(3);
        documentIds.add(5);

        List<DocumentVo> documentVoList = bookService.findBookInfoByDocId(documentIds);

        System.out.println(JSON.toJSONString(documentVoList));
    }

}
