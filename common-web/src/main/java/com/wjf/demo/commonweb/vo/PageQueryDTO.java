package com.wjf.demo.commonweb.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("分页参数")
public class PageQueryDTO {

    @ApiModelProperty("当前页码（不传默认第1页）")
    private Long pageNo = 1L;

    @ApiModelProperty("查询条数（不传默认每页20条）")
    private Long pageSize = 20L;

}
