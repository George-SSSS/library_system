package cn.edu.whu.library.modules.service.impl;

import cn.edu.whu.library.modules.pojo.Journal;
import cn.edu.whu.library.modules.mapper.JournalMapper;
import cn.edu.whu.library.modules.service.JournalService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 期刊信息表 服务实现类
 * </p>
 *
 * @author George
 * @since 2022-12-15
 */
@Service
public class JournalServiceImpl extends ServiceImpl<JournalMapper, Journal> implements JournalService {

}
