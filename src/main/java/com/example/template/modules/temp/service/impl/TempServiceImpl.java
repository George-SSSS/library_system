package com.example.template.modules.temp.service.impl;
import com.example.template.config.TempConfig;
import com.example.template.modules.temp.entity.TempEntity;
import com.example.template.modules.temp.mapper.TempMapper;
import com.example.template.modules.temp.service.ITempService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TempServiceImpl implements ITempService {

    @Autowired
    private TempMapper tempMapper;

    public String serviceMethod() {
        // 业务操作逻辑
 
        return new String();
    }

    @Override
    public List<TempEntity> findAllUser() {
        List<TempEntity> tempEntities = tempMapper.selectList(null);
        return tempEntities;
    }
}
