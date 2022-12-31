package cn.edu.whu.library.modules.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigInteger;

import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 书本列表
 * </p>
 *
 * @author George
 * @since 2022-12-29
 */
@Getter
@Setter
@TableName("book")
public class Book implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 书本 ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 文档列表
     */
    @TableField("document_id")
    private Integer documentId;

    /**
     * 书本 ISBN
     */
    @TableField("ISBN")
    private BigInteger isbn;

    /**
     * 作者 ID list
     */
    @TableField("author_list")
    private String authorList;
}
