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
 * volume table
 * </p>
 *
 * @author George
 * @since 2022-12-29
 */
@Getter
@Setter
@TableName("journal_volume")
public class JournalVolume implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * volume ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 期刊 ID
     */
    @TableField("journal_id")
    private Integer journalId;

    /**
     * volume 序列号
     */
    @TableField("seq_volume")
    private String seqVolume;

    /**
     * 编辑
     */
    @TableField("editor")
    private String editor;
}
