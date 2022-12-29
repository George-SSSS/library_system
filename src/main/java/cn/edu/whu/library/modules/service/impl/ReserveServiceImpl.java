package cn.edu.whu.library.modules.service.impl;

import cn.edu.whu.library.modules.pojo.Reader;
import cn.edu.whu.library.modules.pojo.Reserve;
import cn.edu.whu.library.modules.mapper.ReserveMapper;
import cn.edu.whu.library.modules.service.ReaderService;
import cn.edu.whu.library.modules.service.ReserveService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * <p>
 * 预约列表 服务实现类
 * </p>
 *
 * @author George
 * @since 2022-12-15
 */
@Service
public class ReserveServiceImpl extends ServiceImpl<ReserveMapper, Reserve> implements ReserveService {

    @Autowired
    private ReserveMapper reserveMapper;

    @Override
    public List<Reserve> findAllReserve() {
        List<Reserve> reserves = reserveMapper.selectList(null);
        return reserves;
    }
}
