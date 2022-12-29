package cn.edu.whu.library.modules.service;

import cn.edu.whu.library.modules.pojo.Reader;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 读者信息表 服务类
 * </p>
 *
 * @author George
 * @since 2022-12-15
 */
public interface ReaderService extends IService<Reader> {
    public List<Reader> findAllReader();
}
