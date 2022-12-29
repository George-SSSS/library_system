package cn.edu.whu.library.modules.service.impl;

import cn.edu.whu.library.modules.pojo.Library;
import cn.edu.whu.library.modules.mapper.LibraryMapper;
import cn.edu.whu.library.modules.service.LibraryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 图书馆信息表 服务实现类
 * </p>
 *
 * @author George
 * @since 2022-12-15
 */
@Service
public class LibraryServiceImpl extends ServiceImpl<LibraryMapper, Library> implements LibraryService {

}
