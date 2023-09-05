package com.wjf.demo.commonweb.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@ApiModel("分页数据")
@Data
public class PageVO<T> {
    @ApiModelProperty("当前页码")
    private Long pageNo;

    @ApiModelProperty("每页显示条数")
    private Long pageSize;

    @ApiModelProperty("总数")
    private Long total;

    @ApiModelProperty("查询数据列表")
    List<T> records;
}
