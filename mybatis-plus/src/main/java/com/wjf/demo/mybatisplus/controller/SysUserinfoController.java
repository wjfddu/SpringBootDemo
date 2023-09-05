package com.wjf.demo.mybatisplus.controller;

import com.wjf.demo.commonweb.vo.PageVO;
import com.wjf.demo.mybatisplus.model.dto.UserConditionPageQueryDTO;
import com.wjf.demo.mybatisplus.model.vo.SysUserinfoVO;
import com.wjf.demo.mybatisplus.service.SysUserinfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "系统用户信息管理")
@RestController
@RequestMapping("/sys_userinfo")
public class SysUserinfoController {

    @Autowired
    private SysUserinfoService sysUserinfoService;

    @ApiOperation(value = "分页查询用户信息", notes = "此处为接口描述，方法上慎用tag，不然接口会按tag分组，导致接口层级混乱")
    @GetMapping("/list")
    public PageVO<SysUserinfoVO> queryUserList(UserConditionPageQueryDTO queryDTO){
        return sysUserinfoService.listUser(queryDTO);
    }
}
