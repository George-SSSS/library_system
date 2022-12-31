package cn.edu.whu.library.modules.service;

import cn.edu.whu.library.common.mybatisplus.pojo.PageParam;
import cn.edu.whu.library.modules.mapper.DocumentCopyMapper;
import cn.edu.whu.library.modules.pojo.Document;
import cn.edu.whu.library.modules.pojo.DocumentCopy;
import cn.edu.whu.library.modules.vo.DocumentVo;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * <p>
 * 图书列表 服务类
 * </p>
 *
 * @author George
 * @since 2022-12-15
 */
public interface DocumentCopyService extends IService<DocumentCopy> {
    List<Integer> findDocumentIdByLibIdAndState(Integer libId, Integer state, PageParam pageParam);

    List<DocumentVo> findCopyByDocumentId(Integer documentId);

    List<Integer> findLibraryIdByDocId(Integer documentId);
}
