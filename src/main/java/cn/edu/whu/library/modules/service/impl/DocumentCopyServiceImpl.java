package cn.edu.whu.library.modules.service.impl;

import cn.edu.whu.library.common.mybatisplus.pojo.PageParam;
import cn.edu.whu.library.modules.enums.DocumentType;
import cn.edu.whu.library.modules.mapper.DocumentMapper;
import cn.edu.whu.library.modules.mapper.LibraryMapper;
import cn.edu.whu.library.modules.pojo.Document;
import cn.edu.whu.library.modules.pojo.DocumentCopy;
import cn.edu.whu.library.modules.mapper.DocumentCopyMapper;
import cn.edu.whu.library.modules.pojo.Library;
import cn.edu.whu.library.modules.service.BookService;
import cn.edu.whu.library.modules.service.DocumentCopyService;
import cn.edu.whu.library.modules.service.DocumentService;
import cn.edu.whu.library.modules.service.LibraryService;
import cn.edu.whu.library.modules.vo.DocumentVo;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 图书列表 服务实现类
 * </p>
 *
 * @author George
 * @since 2022-12-15
 */
@Service
public class DocumentCopyServiceImpl extends ServiceImpl<DocumentCopyMapper, DocumentCopy> implements DocumentCopyService {

    @Autowired
    private DocumentCopyMapper copyMapper;
    @Autowired
    private DocumentMapper documentMapper;
    @Autowired
    private LibraryService libraryService;

    @Autowired
    private BookService bookService;

    @Override
    public List<Integer> findDocumentIdByLibIdAndState(Integer libId, Integer state, PageParam pageParam) {
        LambdaQueryWrapper<DocumentCopy> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.select(DocumentCopy::getDocumentId);
        queryWrapper.eq(libId != null, DocumentCopy::getLibId, libId);
        queryWrapper.eq(state != null, DocumentCopy::getLibId, libId);
        queryWrapper.groupBy(DocumentCopy::getDocumentId);

        Page<DocumentCopy> page = new Page<>(pageParam.getCurPage(), pageParam.getPageSize());
        IPage<DocumentCopy> iPage = copyMapper.selectPage(page, queryWrapper);
        List<DocumentCopy> copies = iPage.getRecords();

        List<Integer> documentIds = copies.stream().map(documentCopy -> documentCopy.getDocumentId()).collect(Collectors.toList());

        return documentIds;
    }

    @Override
    public List<DocumentVo> findCopyByDocumentId(Integer documentId) {
        Document document = documentMapper.selectById(documentId);
        DocumentType documentType = DocumentType.getTypeByKey(Integer.valueOf(document.getTypes()));

        DocumentVo documentInfo = null;
        if (documentType == DocumentType.BOOK) {
            documentInfo = bookService.findBookInfoByDocId(documentId);
        } else if(documentType == DocumentType.JOURNAL) {
            // TODO: journal.findBookInfoByDocId
        } else {
            // TODO: conference.findBookInfoByDocId
        }

        List<Integer> libIds = findLibraryIdByDocId(documentId);
        List<Library> librarys = libraryService.findLibraryByIds(libIds);

        List<DocumentVo> documentInfoList = new ArrayList<>();
        for(Library library: librarys) {
            DocumentVo documentVo = new DocumentVo();
            BeanUtils.copyProperties(documentInfo, documentVo);
            documentVo.setLibName(library.getName());
            documentInfoList.add(documentVo);
        }

        return documentInfoList;
    }

    @Override
    public List<Integer> findLibraryIdByDocId(Integer documentId) {
        LambdaQueryWrapper<DocumentCopy> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.select(DocumentCopy::getLibId);
        queryWrapper.eq(DocumentCopy::getState, 0);
        queryWrapper.groupBy(DocumentCopy::getLibId);

        List<DocumentCopy> copies = copyMapper.selectList(queryWrapper);

        return copies.stream().map(copy -> copy.getLibId()).collect(Collectors.toList());
    }


}
