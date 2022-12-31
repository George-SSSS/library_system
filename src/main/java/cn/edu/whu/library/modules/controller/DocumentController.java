package cn.edu.whu.library.modules.controller;

import cn.edu.whu.library.common.mybatisplus.pojo.PageParam;
import cn.edu.whu.library.modules.pojo.Document;
import cn.edu.whu.library.modules.service.DocumentService;
import cn.edu.whu.library.modules.vo.DocumentVo;
import com.alibaba.fastjson2.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

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
    public List<DocumentVo> getAvailableDocument(@RequestParam Map<String, String> param) {
        PageParam pageParam = new PageParam();
        pageParam.setCurPage(Integer.valueOf(param.getOrDefault("curPage", "1")));
        pageParam.setPageSize(Integer.valueOf(param.getOrDefault("pageSize", "10")));

        Integer libId = param.containsKey("libId") ? Integer.valueOf(param.get("libId")) : null;
        Integer state = param.containsKey("state") ? Integer.valueOf(param.get("state")) : null;
        return documentService.findDocumentByLibIdAndState(libId, state, pageParam);
    }

    @RequestMapping("/test")
    public String test(@RequestParam Map<String, String> param) {
        return JSON.toJSONString(param);
    }

}
