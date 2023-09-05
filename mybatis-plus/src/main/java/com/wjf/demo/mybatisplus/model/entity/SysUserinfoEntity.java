package com.wjf.demo.mybatisplus.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.sql.Timestamp;


@Data
@TableName("t_sys_userinfo")
public class SysUserinfoEntity {
    @TableId(type = IdType.ASSIGN_UUID)
    private String userLoginId; // 用户ID
    private String loginname; // 登陆名称
    private Timestamp createtime; // 创建时间
    private Integer logincount; // 登陆次数
    private String password; // 登录密码
    private Integer authfailtimes; // 用户鉴别失败次数(用户做的某项操作没有经过授权则认为鉴别失败)
    private Timestamp lastlogintime; //最后一次尝试登录时间（包括成功和失败时间）
    private Timestamp unlocktime; // 解锁时间
    private Timestamp modpwdtime; // 更新密码时间
    private Timestamp pwdexptime; // 密码过期上锁时间（到期需修改密码帐号才能激活）
    private Integer iscard; // 是否需要ukey登录  0不需要 1需要 默认0
    private String usbkey; // U盾密钥
    private String ukeyseral; // U盾唯一标识 用于绑定用户
    private Integer loginstatus; // 0.登录限制；1.有效；2.删除，3密码过期
    private String remark;
    private String username; // 显示名称
    private String sex; // 性别
    private String deptid; // 部门ID
    private String post; // 职务
    private String telephone; // 联系电话
    private String email; // 电子邮箱
    private Integer status;
    private Integer isdefault; // 默认用户标记
}
