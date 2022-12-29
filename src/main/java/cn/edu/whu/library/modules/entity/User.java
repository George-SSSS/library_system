package cn.edu.whu.library.modules.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class User implements Serializable {
    /**
     * id
     * */
    private Integer id;
    /**
     * 头像
     * */
    private String avatar;
    /**
     * 邮箱
     * */
    private String email;
    /**
     * 账号
     * */
    private String name;
    /**
     * 密码
     * */
    private String password;
    /**
     * 用户名
     * */
    private String username;
}