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
 * 出本社列表
 * </p>
 *
 * @author George
 * @since 2022-12-29
 */
@Getter
@Setter
@TableName("publisher")
public class Publisher implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 出版社 ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 出版社名称
     */
    @TableField("name")
    private String name;

    /**
     * 出版社地址
     */
    @TableField("address")
    private String address;
}
