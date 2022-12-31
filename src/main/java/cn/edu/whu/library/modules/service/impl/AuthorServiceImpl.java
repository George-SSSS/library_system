package cn.edu.whu.library.modules.service.impl;

import cn.edu.whu.library.modules.pojo.Author;
import cn.edu.whu.library.modules.mapper.AuthorMapper;
import cn.edu.whu.library.modules.service.AuthorService;
import com.alibaba.fastjson2.JSONArray;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 作者列表 服务实现类
 * </p>
 *
 * @author George
 * @since 2022-12-15
 */
@Service
public class AuthorServiceImpl extends ServiceImpl<AuthorMapper, Author> implements AuthorService {

    @Autowired
    private AuthorMapper authorMapper;

    @Override
    public String findAuthorListById(String authors) {
        List<Integer> authorIdList = new ArrayList<>();
        String[] authorIds = authors.split(",");
        for(String authorId: authorIds) {
            authorIdList.add(Integer.valueOf(authorId.trim()));
        }

        LambdaQueryWrapper<Author> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.select(Author::getName);
        queryWrapper.in(Author::getId, authorIdList);
        List<Author> authorList = authorMapper.selectList(queryWrapper);

        StringBuilder sb = new StringBuilder();
        for (Author author: authorList) {
            sb.append(author.getName());
            sb.append(",");
        }

//        List<String> authorList = authorMapper.findAuthorListById(authorIdList);
        return sb.substring(0, sb.length() - 1);
    }
}
