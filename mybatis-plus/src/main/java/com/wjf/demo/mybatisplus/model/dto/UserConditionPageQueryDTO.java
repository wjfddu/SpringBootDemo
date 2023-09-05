package com.wjf.demo.mybatisplus.model.dto;

import com.wjf.demo.commonweb.vo.PageQueryDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("用户条件查询分页对象")
@Data
public class UserConditionPageQueryDTO extends PageQueryDTO {
    @ApiModelProperty("登陆名称")
    private String loginname;
}
