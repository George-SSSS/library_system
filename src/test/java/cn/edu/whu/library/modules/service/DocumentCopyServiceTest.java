package cn.edu.whu.library.modules.service;

import cn.edu.whu.library.LibraryApplication;
import cn.edu.whu.library.common.mybatisplus.pojo.PageParam;
import cn.edu.whu.library.modules.pojo.DocumentCopy;
import cn.edu.whu.library.modules.vo.DocumentVo;
import com.alibaba.fastjson2.JSON;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest(classes = LibraryApplication.class)
public class DocumentCopyServiceTest {

    @Autowired
    DocumentCopyService copyService;

    @Test
    public void findDocumentIdByLibIdAndState() {
        PageParam pageParam = new PageParam();
        pageParam.setCurPage(1);
        pageParam.setPageSize(10);

        Integer libId = null;
        Integer state = null;

        List<Integer> documentIds = copyService.findDocumentIdByLibIdAndState(libId, state, pageParam);
        System.out.println(JSON.toJSONString(documentIds));
    }

    @Test
    public void findLibraryIdByDocId() {
        Integer documentId = 1;

        List<Integer> libraryIdByDocId = copyService.findLibraryIdByDocId(documentId);

        System.out.println(JSON.toJSONString(libraryIdByDocId));
    }

    @Test
    public void findCopyByDocumentId() {
        Integer documentId = 1;

        List<DocumentVo> copyByDocumentId = copyService.findCopyByDocumentId(documentId);

        System.out.println(JSON.toJSONString(copyByDocumentId));
    }

}
