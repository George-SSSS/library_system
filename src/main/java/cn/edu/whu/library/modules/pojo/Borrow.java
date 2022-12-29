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
 * 借阅信息表
 * </p>
 *
 * @author George
 * @since 2022-12-29
 */
@Getter
@Setter
@TableName("borrow")
public class Borrow implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 借阅 ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 读者 ID
     */
    @TableField("reader_id")
    private Integer readerId;

    /**
     * 借阅时间
     */
    @TableField("borrow_time")
    private LocalDateTime borrowTime;

    /**
     * 归还时间
     */
    @TableField("return_time")
    private LocalDateTime returnTime;
}
