package com.wjf.demo.mybatisplus.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wjf.demo.commonweb.vo.PageVO;
import com.wjf.demo.mybatisplus.mapper.SysUserinfoMapper;
import com.wjf.demo.mybatisplus.model.dto.UserConditionPageQueryDTO;
import com.wjf.demo.mybatisplus.model.entity.SysUserinfoEntity;
import com.wjf.demo.mybatisplus.model.vo.SysUserinfoVO;
import com.wjf.demo.mybatisplus.service.SysUserinfoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SysUserinfoServiceImpl extends ServiceImpl<SysUserinfoMapper, SysUserinfoEntity> implements SysUserinfoService {


    @Override
    public PageVO<SysUserinfoVO> listUser(UserConditionPageQueryDTO queryDTO) {
        Page<SysUserinfoEntity> page = new Page(queryDTO.getPageNo(), queryDTO.getPageSize());
        LambdaQueryWrapper<SysUserinfoEntity> queryWrapper = Wrappers.<SysUserinfoEntity>lambdaQuery()
                .eq(StringUtils.isNotBlank(queryDTO.getLoginname()), SysUserinfoEntity::getLoginname, queryDTO.getLoginname());
        Page<SysUserinfoEntity> pageData = this.page(page, queryWrapper);

        List<SysUserinfoVO> records = new ArrayList();
        pageData.getRecords().stream().forEach(entity -> {
            SysUserinfoVO resp = new SysUserinfoVO();
            BeanUtils.copyProperties(entity, resp);
            records.add(resp);
        });

        PageVO<SysUserinfoVO> retPage = new PageVO<>();
        retPage.setPageNo(pageData.getCurrent());
        retPage.setPageSize(pageData.getSize());
        retPage.setTotal(pageData.getTotal());
        retPage.setRecords(records);

        return retPage;
    }

}
