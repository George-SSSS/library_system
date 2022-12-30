package cn.edu.whu.library.modules.service;

import cn.edu.whu.library.modules.mapper.DocumentCopyMapper;
import cn.edu.whu.library.modules.pojo.Document;
import cn.edu.whu.library.modules.pojo.DocumentCopy;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.beans.factory.annotation.Autowired;

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

    List<Document> findAvailableDocument(Integer libId, Integer state);
}
