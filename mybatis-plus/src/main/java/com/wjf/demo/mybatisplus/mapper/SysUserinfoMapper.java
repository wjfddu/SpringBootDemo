package com.wjf.demo.mybatisplus.mapper;



import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wjf.demo.mybatisplus.model.entity.SysUserinfoEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysUserinfoMapper extends BaseMapper<SysUserinfoEntity> {
    List<SysUserinfoEntity> selectAll();
}
