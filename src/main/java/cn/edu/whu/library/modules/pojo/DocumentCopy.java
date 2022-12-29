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
 * 图书列表
 * </p>
 *
 * @author George
 * @since 2022-12-29
 */
@Getter
@Setter
@TableName("document_copy")
public class DocumentCopy implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 图书 ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 图书馆 ID
     */
    @TableField("lib_id")
    private Integer libId;

    /**
     * 文档 ID
     */
    @TableField("document_id")
    private Integer documentId;

    /**
     * 图书序列号
     */
    @TableField("seq_copy")
    private Byte seqCopy;

    /**
     * 图书状态； 0: available, 1: reserved; 2: borrowed
     */
    @TableField("state")
    private Byte state;
}
