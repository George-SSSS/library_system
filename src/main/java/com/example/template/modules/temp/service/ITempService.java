package com.example.template.modules.temp.service;

import com.example.template.modules.temp.entity.TempEntity;

import java.util.List;

public interface ITempService {
    public String serviceMethod();

    public List<TempEntity> findAllUser();
}
