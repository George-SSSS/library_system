package cn.edu.whu.library.modules.mapper;

import cn.edu.whu.library.modules.pojo.DocumentCopy;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 图书列表 Mapper 接口
 * </p>
 *
 * @author George
 * @since 2022-12-29
 */
public interface DocumentCopyMapper extends BaseMapper<DocumentCopy> {
    List<DocumentCopy> findCopyByDocumentId(@Param("documentId") Integer documentId);
}
