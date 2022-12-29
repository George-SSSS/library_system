package cn.edu.whu.library.modules.service.impl;

import cn.edu.whu.library.modules.pojo.Book;
import cn.edu.whu.library.modules.mapper.BookMapper;
import cn.edu.whu.library.modules.service.BookService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 书本列表 服务实现类
 * </p>
 *
 * @author George
 * @since 2022-12-15
 */
@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements BookService {

}
