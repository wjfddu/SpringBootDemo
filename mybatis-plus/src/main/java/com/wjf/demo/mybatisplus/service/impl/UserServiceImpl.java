package com.wjf.demo.mybatisplus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wjf.demo.mybatisplus.mapper.UserMapper;
import com.wjf.demo.mybatisplus.model.entity.UserEntity;
import com.wjf.demo.mybatisplus.model.resp.UserResp;
import com.wjf.demo.mybatisplus.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserEntity> implements UserService {

    @Override
    public List<UserResp> listUser() {
        List<UserResp> retData = new ArrayList();
        List<UserEntity> data = this.list();
        data.stream().forEach(userEntity -> {
            UserResp userResp = new UserResp();
            BeanUtils.copyProperties(userEntity, userResp);
            retData.add(userResp);
        });
        return retData;
    }
}
