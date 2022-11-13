package com.example.template.service.impl;
import com.example.template.config.TempConfig;
import com.example.template.service.TempService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TempServiceImpl implements TempService {

    @Autowired
    private TempConfig tempConfig;

    public String serviceMethod() {
        // 业务操作逻辑

        return new String();
    }
}
