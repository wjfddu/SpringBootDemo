package com.wjf.demo.mybatisplus.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wjf.demo.mybatisplus.model.entity.UserEntity;
import com.wjf.demo.mybatisplus.model.resp.UserResp;

import java.util.List;

public interface UserService extends IService<UserEntity> {

    List<UserResp> listUser();

}
