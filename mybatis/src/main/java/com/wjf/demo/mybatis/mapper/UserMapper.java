package com.wjf.demo.mybatis.mapper;


import com.wjf.demo.mybatis.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    List<User> selectAll();
}
