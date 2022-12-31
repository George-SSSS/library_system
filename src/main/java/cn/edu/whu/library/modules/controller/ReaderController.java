package cn.edu.whu.library.modules.controller;

import cn.edu.whu.library.common.mybatisplus.pojo.PageParam;
import cn.edu.whu.library.modules.pojo.Reader;
import cn.edu.whu.library.modules.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 读者信息表 前端控制器
 * </p>
 *
 * @author George
 * @since 2022-12-15
 */
@RestController
@RequestMapping("/reader")
public class ReaderController {

    @Autowired
    private ReaderService readerService;

    @RequestMapping("/allReaders")
    public List<Reader> getAllReaders(@RequestParam Map<String, String> param) {
        PageParam pageParam = new PageParam();
        pageParam.setCurPage(Integer.valueOf(param.getOrDefault("curPage", "1")));
        pageParam.setPageSize(Integer.valueOf(param.getOrDefault("pageSize", "10")));
        return readerService.findAllReader(pageParam);
    }

    @RequestMapping("/getByAccount")
    public List<Reader> getByAccount(@RequestParam("account") String account) {
        return readerService.findByAccount(account);
    }
}
