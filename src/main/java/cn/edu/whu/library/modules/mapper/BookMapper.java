package cn.edu.whu.library.modules.mapper;

import cn.edu.whu.library.modules.pojo.Book;
import cn.edu.whu.library.modules.vo.DocumentVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 书本列表 Mapper 接口
 * </p>
 *
 * @author George
 * @since 2022-12-29
 */
public interface BookMapper extends BaseMapper<Book> {

    List<DocumentVo> findBookInfoByDocId(@Param("docIdList") List<Integer> docIdList);
}
