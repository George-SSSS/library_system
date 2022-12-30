package cn.edu.whu.library.modules.controller;

import cn.edu.whu.library.modules.pojo.Document;
import cn.edu.whu.library.modules.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 文档列表 前端控制器
 * </p>
 *
 * @author George
 * @since 2022-12-15
 */
@RestController
@RequestMapping("/document")
public class DocumentController {

    @Autowired
    private DocumentService documentService;

    @RequestMapping("/getAvailableDocument")
    public List<Document> getAvailableDocument(@RequestParam("libId") Integer libId,
                                                @RequestParam("state") Integer state) {
        return documentService.findAvailableDocument(libId, state);
    }


}
