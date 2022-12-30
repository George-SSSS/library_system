package cn.edu.whu.library.modules.mapper;

import cn.edu.whu.library.modules.pojo.Document;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 文档列表 Mapper 接口
 * </p>
 *
 * @author George
 * @since 2022-12-29
 */

public interface DocumentMapper extends BaseMapper<Document> {
    List<Document> findAvailableDocument(@Param("libId") Integer libId, @Param("state") Integer state);
}
