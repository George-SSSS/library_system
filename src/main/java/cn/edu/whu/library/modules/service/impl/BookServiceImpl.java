package cn.edu.whu.library.modules.service.impl;

import cn.edu.whu.library.modules.pojo.Book;
import cn.edu.whu.library.modules.mapper.BookMapper;
import cn.edu.whu.library.modules.service.BookService;
import cn.edu.whu.library.modules.vo.DocumentVo;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 书本列表 服务实现类
 * </p>
 *
 * @author George
 * @since 2022-12-15
 */

@Log4j2
@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements BookService {

    @Autowired
    private BookMapper bookMapper;

    @Override
    public List<Book> findByDocId(Integer documentId) {
        List<Integer> documentIds = new ArrayList<>();
        documentIds.add(documentId);
        return findByDocId(documentIds);
    }

    @Override
    public List<Book> findByDocId(List<Integer> documentIds) {
        LambdaQueryWrapper<Book> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.in(Book::getDocumentId, documentIds);

        List<Book> books = bookMapper.selectList(queryWrapper);

        return books;
    }

    @Override
    public DocumentVo findBookInfoByDocId(Integer documentId) {
        List<Integer> documentIds = new ArrayList<>();
        documentIds.add(documentId);
        List<DocumentVo> bookInfoList = bookMapper.findBookInfoByDocId(documentIds);
        return bookInfoList.size() > 0 ? bookInfoList.get(0) : null;
    }

    @Override
    public List<DocumentVo> findBookInfoByDocId(List<Integer> documentIds) {
        List<DocumentVo> documentVoList = bookMapper.findBookInfoByDocId(documentIds);

        return documentVoList;
    }

}
