package cn.edu.whu.library.modules.service;

import cn.edu.whu.library.common.mybatisplus.pojo.PageParam;
import cn.edu.whu.library.modules.enums.DocumentType;
import cn.edu.whu.library.modules.pojo.Document;
import cn.edu.whu.library.modules.vo.DocumentVo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 文档列表 服务类
 * </p>
 *
 * @author George
 * @since 2022-12-15
 */
public interface DocumentService extends IService<Document> {

    List<DocumentVo> findDocumentByLibIdAndState(Integer libId, Integer state, PageParam pageParam);
}
