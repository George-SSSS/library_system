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
 * 读者信息表
 * </p>
 *
 * @author George
 * @since 2022-12-29
 */
@Getter
@Setter
@TableName("reader")
public class Reader implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 读者 ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 读者登录账户
     */
    @TableField("account")
    private String account;

    /**
     * 读者登录密码
     */
    @TableField("password")
    private String password;

    /**
     * 用户名
     */
    @TableField("username")
    private String username;

    /**
     * 居住地址
     */
    @TableField("address")
    private String address;

    /**
     * 联络电话
     */
    @TableField("phone_number")
    private String phoneNumber;

    /**
     * 读者类型；0: student, 1: faculty, 2: staff
     */
    @TableField("reader_type")
    private Byte readerType;

    /**
     * 预约数
     */
    @TableField("num_of_reserving")
    private Byte numOfReserving;

    /**
     * 借阅数
     */
    @TableField("num_of_borrowing")
    private Byte numOfBorrowing;

    /**
     * 总借阅数
     */
    @TableField("total_borrow")
    private Byte totalBorrow;

    /**
     * 由于逾期归还而积累的罚款；若未还清罚款，则无法再进行预约和借阅
     */
    @TableField("fine")
    private Integer fine;
}
