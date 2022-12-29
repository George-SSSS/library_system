package cn.edu.whu.library.modules.service.impl;
import cn.edu.whu.library.modules.entity.Library;
import cn.edu.whu.library.modules.mapper.TempMapper;
import cn.edu.whu.library.modules.service.TempService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TempServiceImpl implements TempService {

    @Autowired
    private TempMapper tempMapper;

    public String serviceMethod() {
        // 业务操作逻辑
 
        return new String();
    }

    @Override
    public List<Library> findAllUser() {
        List<Library> tempEntities = tempMapper.selectList(null);
        return tempEntities;
    }
}
