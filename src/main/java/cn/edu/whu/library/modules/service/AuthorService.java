package cn.edu.whu.library.modules.service;

import cn.edu.whu.library.modules.pojo.Author;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 作者列表 服务类
 * </p>
 *
 * @author George
 * @since 2022-12-15
 */
public interface AuthorService extends IService<Author> {
    String findAuthorListById(String authors);
}
