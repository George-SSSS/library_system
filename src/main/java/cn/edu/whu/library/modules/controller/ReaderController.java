package cn.edu.whu.library.modules.controller;

import cn.edu.whu.library.modules.pojo.Reader;
import cn.edu.whu.library.modules.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    public List<Reader> getAllReaders() {
        System.out.println("findAllReaders");
        return readerService.findAllReader();
    }

    @RequestMapping("/getByAccount")
    public List<Reader> getByAccount(@RequestParam("account") String account) {
        return readerService.findByAccount(account);
    }
}
