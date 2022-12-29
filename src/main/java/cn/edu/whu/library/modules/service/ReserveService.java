package cn.edu.whu.library.modules.service;

import cn.edu.whu.library.modules.pojo.Reader;
import cn.edu.whu.library.modules.pojo.Reserve;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 预约列表 服务类
 * </p>
 *
 * @author George
 * @since 2022-12-15
 */
public interface ReserveService extends IService<Reserve> {
    public List<Reserve> findAllReserve();
}
