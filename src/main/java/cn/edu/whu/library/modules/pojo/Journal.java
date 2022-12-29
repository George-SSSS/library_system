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
 * 期刊信息表
 * </p>
 *
 * @author George
 * @since 2022-12-29
 */
@Getter
@Setter
@TableName("journal")
public class Journal implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 期刊 ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 文档列表
     */
    @TableField("document_id")
    private Integer documentId;

    /**
     * 期刊名称
     */
    @TableField("name")
    private String name;

    /**
     * 研究范围
     */
    @TableField("scope")
    private String scope;

    /**
     * 编辑列表
     */
    @TableField("editor_list")
    private String editorList;
}
