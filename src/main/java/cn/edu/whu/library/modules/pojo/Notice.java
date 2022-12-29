package cn.edu.whu.library.modules.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 通知信息表
 * </p>
 *
 * @author George
 * @since 2022-12-29
 */
@Getter
@Setter
@TableName("notice")
public class Notice implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 通知 ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 读者 ID
     */
    @TableField("reader_id")
    private Integer readerId;

    /**
     * 通知内容
     */
    @TableField("content")
    private String content;

    /**
     * 是否已读； 0: 未读, 1: 已读
     */
    @TableField("is_read")
    private Byte isRead;

    /**
     * 通知生成时间
     */
    @TableField("create_time")
    private LocalDateTime createTime;
}
