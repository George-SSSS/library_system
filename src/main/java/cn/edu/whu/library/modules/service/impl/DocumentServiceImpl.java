package cn.edu.whu.library.modules.service.impl;

import cn.edu.whu.library.common.mybatisplus.pojo.PageParam;
import cn.edu.whu.library.modules.enums.DocumentType;
import cn.edu.whu.library.modules.pojo.Document;
import cn.edu.whu.library.modules.mapper.DocumentMapper;
import cn.edu.whu.library.modules.service.AuthorService;
import cn.edu.whu.library.modules.service.BookService;
import cn.edu.whu.library.modules.service.DocumentCopyService;
import cn.edu.whu.library.modules.service.DocumentService;
import cn.edu.whu.library.modules.vo.DocumentVo;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 文档列表 服务实现类
 * </p>
 *
 * @author George
 * @since 2022-12-15
 */
@Service
public class DocumentServiceImpl extends ServiceImpl<DocumentMapper, Document> implements DocumentService {

    @Autowired
    private DocumentMapper documentMapper;

    @Autowired
    private DocumentCopyService copyService;

    @Autowired
    private AuthorService authorService;

    @Autowired
    private BookService bookService;

    public List<DocumentVo> findDocumentByLibIdAndState(Integer libId, Integer state, PageParam pageParam) {
        List<Integer> documentIds = copyService.findDocumentIdByLibIdAndState(libId, state, pageParam);

        LambdaQueryWrapper<Document> documentLambdaQueryWrapper = Wrappers.lambdaQuery();
        documentLambdaQueryWrapper.in(Document::getId, documentIds);
        List<Document> documents = documentMapper.selectList(documentLambdaQueryWrapper);

        List<Integer> bookDocIDList = documents.stream().filter(document -> document.getTypes() == DocumentType.BOOK.getKey())
                                                            .map(document -> document.getId())
                                                            .collect(Collectors.toList());

        List<DocumentVo> books = bookService.findBookInfoByDocId(bookDocIDList);

        List<DocumentVo> BookVo = books.stream().map(book -> {
            book.setAuthor(authorService.findAuthorListById(book.getAuthor()));
            return book;
        }).collect(Collectors.toList());

        // TODO: 补充 journal 和 conference

        List<Integer> journalDocIDList = documents.stream().filter(document -> document.getTypes() == DocumentType.JOURNAL.getKey())
                                                            .map(document -> document.getId())
                                                            .collect(Collectors.toList());

        List<Integer> proceedingDocIDList = documents.stream().filter(document -> document.getTypes() == DocumentType.CONFERENCE_PROCEEDINGS.getKey())
                                                            .map(document -> document.getId())
                                                            .collect(Collectors.toList());

        List<Document> journals = documents.stream().filter(document -> document.getTypes() == DocumentType.JOURNAL.getKey()).collect(Collectors.toList());
        List<Document> proceedings = documents.stream().filter(document -> document.getTypes() == DocumentType.CONFERENCE_PROCEEDINGS.getKey()).collect(Collectors.toList());

        return BookVo;
    }

}
