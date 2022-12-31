package cn.edu.whu.library.modules.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 文档列表
 * </p>
 *
 * @author George
 * @since 2022-12-29
 */
@Getter
@Setter
@TableName("document")
public class Document implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 文档 ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 文档标题
     */
    @TableField("title")
    private String title;

    /**
     * 出版社 ID
     */
    @TableField("publisher_id")
    private Integer publisherId;

    /**
     * 出版日期
     */
    @TableField("publisher_date")
    private String publisherDate;

    /**
     * 0: book, 1: journal volume, 2: conference proceedings
     */
    @TableField("types")
    private Byte types;
}
