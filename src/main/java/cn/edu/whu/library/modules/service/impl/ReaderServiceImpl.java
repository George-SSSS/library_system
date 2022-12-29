package cn.edu.whu.library.modules.service.impl;

import cn.edu.whu.library.modules.pojo.Reader;
import cn.edu.whu.library.modules.mapper.ReaderMapper;
import cn.edu.whu.library.modules.service.ReaderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 读者信息表 服务实现类
 * </p>
 *
 * @author George
 * @since 2022-12-15
 */
@Service
public class ReaderServiceImpl extends ServiceImpl<ReaderMapper, Reader> implements ReaderService {

    @Autowired
    private ReaderMapper readerMapper;

    @Override
    public List<Reader> findAllReader() {
        List<Reader> readers = readerMapper.selectList(null);
        return readers;
    }
}
