package cn.edu.whu.library.common.mybatisplus.pojo;

import lombok.Data;

@Data
public class PageParam {
    private Integer curPage;
    private Integer pageSize;
    private Integer totalPage;
}
