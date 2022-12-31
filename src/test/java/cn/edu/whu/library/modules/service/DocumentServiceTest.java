package cn.edu.whu.library.modules.service;

import cn.edu.whu.library.LibraryApplication;
import cn.edu.whu.library.common.mybatisplus.pojo.PageParam;
import cn.edu.whu.library.modules.enums.Role;
import cn.edu.whu.library.modules.pojo.Document;
import cn.edu.whu.library.modules.vo.DocumentVo;
import com.alibaba.fastjson2.JSON;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;

@SpringBootTest(classes = LibraryApplication.class)
public class DocumentServiceTest {

    @Autowired
    private DocumentService documentService;

    @Test
    public void findDocumentByLibIdAndState() {
        PageParam pageParam = new PageParam();
        pageParam.setCurPage(1);
        pageParam.setPageSize(10);

        Integer libId = null;
        Integer state = null;

        List<DocumentVo> documentVoList = documentService.findDocumentByLibIdAndState(libId, state, pageParam);
        System.out.println(JSON.toJSONString(documentVoList));
    }

}
