package cn.edu.whu.library.modules.service;

import cn.edu.whu.library.modules.pojo.Book;
import cn.edu.whu.library.modules.vo.DocumentVo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 书本列表 服务类
 * </p>
 *
 * @author George
 * @since 2022-12-15
 */
public interface BookService extends IService<Book> {
    List<Book> findByDocId(Integer documentId);

    List<Book> findByDocId(List<Integer> documentIds);

    DocumentVo findBookInfoByDocId(Integer documentId);
    List<DocumentVo> findBookInfoByDocId(List<Integer> documentIds);
}
