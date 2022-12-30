package cn.edu.whu.library.modules.service.impl;

import cn.edu.whu.library.modules.mapper.DocumentCopyMapper;
import cn.edu.whu.library.modules.pojo.Document;
import cn.edu.whu.library.modules.mapper.DocumentMapper;
import cn.edu.whu.library.modules.pojo.DocumentCopy;
import cn.edu.whu.library.modules.service.DocumentService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<Document> findAvailableDocument(Integer libId, Integer state) {
        return documentMapper.findAvailableDocument(libId, state);
    }

}
