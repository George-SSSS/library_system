package cn.edu.whu.library.modules.controller;

import cn.edu.whu.library.modules.pojo.Reserve;
import cn.edu.whu.library.modules.service.ReserveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 预约列表 前端控制器
 * </p>
 *
 * @author George
 * @since 2022-12-15
 */
@RestController
@RequestMapping("/modules/reserve")
public class ReserveController {

    @Autowired
    private ReserveService reserveService;

    @RequestMapping("/allReserves")
    public List<Reserve> getAllReserves() {
        System.out.println("findAllReserves");
        return reserveService.findAllReserve();
    }
}
