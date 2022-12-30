package cn.edu.whu.library.modules.service.impl;

import cn.edu.whu.library.modules.pojo.Reader;
import cn.edu.whu.library.modules.mapper.ReaderMapper;
import cn.edu.whu.library.modules.service.ReaderService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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

    public List<Reader> findByAccount(String account) {
        List<Reader> readers = readerMapper.findAllByAccount(account);
        return readers;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LambdaQueryWrapper<Reader> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Reader::getUsername, username);
        Reader reader = readerMapper.selectOne(queryWrapper);
        if(reader == null) {
            throw new UsernameNotFoundException("此用户不存在！");
        }
        return reader;
    }
}
