package cn.edu.whu.library.modules.mapper;

import cn.edu.whu.library.modules.pojo.Reader;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 读者信息表 Mapper 接口
 * </p>
 *
 * @author George
 * @since 2022-12-29
 */
public interface ReaderMapper extends BaseMapper<Reader> {
    List<Reader> findAllByAccount(@Param("account") String account);
}
