package cn.edu.whu.library.modules.service.impl;

import cn.edu.whu.library.modules.pojo.Author;
import cn.edu.whu.library.modules.mapper.AuthorMapper;
import cn.edu.whu.library.modules.service.AuthorService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 作者列表 服务实现类
 * </p>
 *
 * @author George
 * @since 2022-12-15
 */
@Service
public class AuthorServiceImpl extends ServiceImpl<AuthorMapper, Author> implements AuthorService {

}
