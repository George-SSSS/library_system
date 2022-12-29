package cn.edu.whu.library.modules.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 图书馆信息表
 * </p>
 *
 * @author George
 * @since 2022-12-29
 */
@Getter
@Setter
@TableName("library")
public class Library implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 图书馆 ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 图书馆分管名称
     */
    @TableField("name")
    private String name;

    /**
     * 图书馆地址
     */
    @TableField("location")
    private String location;
}
