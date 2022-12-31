package cn.edu.whu.library.modules.mapper;

import cn.edu.whu.library.modules.pojo.Author;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 作者列表 Mapper 接口
 * </p>
 *
 * @author George
 * @since 2022-12-29
 */
public interface AuthorMapper extends BaseMapper<Author> {
    List<String> findAuthorListById(@Param("authorIdList") List<Integer> authorIdList);
}
