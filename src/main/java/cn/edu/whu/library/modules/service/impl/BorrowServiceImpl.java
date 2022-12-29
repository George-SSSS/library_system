package cn.edu.whu.library.modules.service.impl;

import cn.edu.whu.library.modules.pojo.Borrow;
import cn.edu.whu.library.modules.mapper.BorrowMapper;
import cn.edu.whu.library.modules.service.BorrowService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 借阅信息表 服务实现类
 * </p>
 *
 * @author George
 * @since 2022-12-15
 */
@Service
public class BorrowServiceImpl extends ServiceImpl<BorrowMapper, Borrow> implements BorrowService {

}
