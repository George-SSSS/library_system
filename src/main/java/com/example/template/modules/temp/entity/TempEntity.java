package com.example.template.modules.temp.entity;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class TempEntity implements Serializable {
    /**
     * id
     **/
    private Integer id;
    /**
     * 头像
     **/
    private String avatar;
    /**
     * 邮箱
     **/
    private String email;
    /**
     * 账号
     **/
    private String name;
    /**
     * 密码
     **/
    private String password;
    /**
     * 用户名
     **/
    private String username;

}
