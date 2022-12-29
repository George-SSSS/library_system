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
 * 预约列表
 * </p>
 *
 * @author George
 * @since 2022-12-29
 */
@Getter
@Setter
@TableName("reserve")
public class Reserve implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 预约 ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 读者 ID
     */
    @TableField("reader_id")
    private Integer readerId;

    /**
     * 文档 ID
     */
    @TableField("doc_id")
    private Integer docId;

    /**
     * 图书馆 ID
     */
    @TableField("lib_id")
    private Integer libId;

    /**
     * COPY ID
     */
    @TableField("copy_id")
    private Integer copyId;

    /**
     * 预约状态；0: 正在预约, 1: 已预约，但未借阅, 2: 已借阅, 3: 已逾期
     */
    @TableField("reserve_state")
    private Byte reserveState;

    /**
     * 预约时间
     */
    @TableField("reserve_time")
    private LocalDateTime reserveTime;

    /**
     * 借阅截止时间
     */
    @TableField("deadline")
    private LocalDateTime deadline;
}
