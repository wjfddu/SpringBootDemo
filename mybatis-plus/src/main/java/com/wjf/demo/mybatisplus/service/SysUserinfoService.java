package com.wjf.demo.mybatisplus.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wjf.demo.commonweb.vo.PageVO;
import com.wjf.demo.mybatisplus.model.dto.UserConditionPageQueryDTO;
import com.wjf.demo.mybatisplus.model.entity.SysUserinfoEntity;
import com.wjf.demo.mybatisplus.model.vo.SysUserinfoVO;


import java.util.List;

public interface SysUserinfoService extends IService<SysUserinfoEntity> {

    PageVO<SysUserinfoVO> listUser(UserConditionPageQueryDTO queryDTO);
}
