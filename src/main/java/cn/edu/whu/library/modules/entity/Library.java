package cn.edu.whu.library.modules.entity;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 图书馆信息表
 */
@Data
public class Library implements Serializable {

    /**
     * 图书馆 ID
     **/
    private Integer id;

    /**
     * 图书馆分管名称
     **/
    private String name;
    /**
     * 图书馆地址
     **/
    private String location;
}
