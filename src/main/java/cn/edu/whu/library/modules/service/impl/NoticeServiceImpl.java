package cn.edu.whu.library.modules.service.impl;

import cn.edu.whu.library.modules.pojo.Notice;
import cn.edu.whu.library.modules.mapper.NoticeMapper;
import cn.edu.whu.library.modules.service.NoticeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 通知信息表 服务实现类
 * </p>
 *
 * @author George
 * @since 2022-12-15
 */
@Service
public class NoticeServiceImpl extends ServiceImpl<NoticeMapper, Notice> implements NoticeService {

}
