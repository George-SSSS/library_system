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
 * 会议论文信息表
 * </p>
 *
 * @author George
 * @since 2022-12-29
 */
@Getter
@Setter
@TableName("conference_proceeding")
public class ConferenceProceeding implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 会议论文 ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 文档列表
     */
    @TableField("document_id")
    private Integer documentId;

    /**
     * 会议日期
     */
    @TableField("date")
    private LocalDate date;

    /**
     * 会议地点
     */
    @TableField("location")
    private String location;

    /**
     * 会议编辑
     */
    @TableField("editor")
    private String editor;
}
