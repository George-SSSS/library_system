package cn.edu.whu.library.modules.controller;

import cn.edu.whu.library.modules.pojo.Document;
import cn.edu.whu.library.modules.service.DocumentCopyService;
import cn.edu.whu.library.modules.vo.DocumentVo;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 图书列表 前端控制器
 * </p>
 *
 * @author George
 * @since 2022-12-15
 */
@RestController
@RequestMapping("/copy")
public class DocumentCopyController {

    @Autowired
    DocumentCopyService copyService;

    @RequestMapping("/getCopyByDocId")
    public List<DocumentVo> findCopyByDocumentId(@NotNull @RequestParam("docId") Integer docId) {
        return copyService.findCopyByDocumentId(docId);
    }
}
