package com.wjf.demo.mybatisplus.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.sql.Timestamp;


@ApiModel("系统用户信息")
@Data
public class SysUserinfoVO {
    @ApiModelProperty("用户ID")
    private String userLoginId;

    @ApiModelProperty("登陆名称")
    private String loginname;

    @ApiModelProperty(value = "创建时间", dataType ="java.lang.String")
    private Timestamp createtime;

    @ApiModelProperty("登陆次数")
    private Integer logincount;

    @ApiModelProperty("登录密码")
    private String password;

    @ApiModelProperty("用户鉴别失败次数(用户做的某项操作没有经过授权则认为鉴别失败)")
    private Integer authfailtimes;

    @ApiModelProperty(value = "最后一次尝试登录时间（包括成功和失败时间）", dataType ="java.lang.String")
    private Timestamp lastlogintime;

    @ApiModelProperty(value = "解锁时间", dataType ="java.lang.String")
    private Timestamp unlocktime;

    @ApiModelProperty(value = "更新密码时间", dataType ="java.lang.String")
    private Timestamp modpwdtime;

    @ApiModelProperty(value = "密码过期上锁时间（到期需修改密码帐号才能激活）", dataType ="java.lang.String")
    private Timestamp pwdexptime;

    @ApiModelProperty("是否需要ukey登录  0不需要 1需要 默认0")
    private Integer iscard;

    @ApiModelProperty("U盾密钥")
    private String usbkey;

    @ApiModelProperty("U盾唯一标识 用于绑定用户")
    private String ukeyseral;

    @ApiModelProperty("0.登录限制；1.有效；2.删除，3密码过期")
    private Integer loginstatus;

    @ApiModelProperty("")
    private String remark;

    @ApiModelProperty("显示名称")
    private String username;

    @ApiModelProperty("性别")
    private String sex;

    @ApiModelProperty("部门ID")
    private String deptid;

    @ApiModelProperty("职务")
    private String post;

    @ApiModelProperty("联系电话")
    private String telephone;

    @ApiModelProperty("电子邮箱")
    private String email;

    @ApiModelProperty("")
    private Integer status;

//    @ApiModelProperty("默认用户标记")
//    private Integer isdefault;
}
