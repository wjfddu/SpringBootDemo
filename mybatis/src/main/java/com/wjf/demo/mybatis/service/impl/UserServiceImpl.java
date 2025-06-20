package com.wjf.demo.mybatis.service.impl;

import com.wjf.demo.mybatis.mapper.UserMapper;
import com.wjf.demo.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author JF
 * @created 2025/6/20 15:53
 * @description
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserService service; // 自己注入自己


    @Resource
    private UserMapper userMapper;


    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void addUser(String name) {
        userMapper.addUser(name);

        int i = 1/0;

        userMapper.addUser(name + name);
    }

    @Override
    @Transactional
    public void add5User() {
//        for (int i=1; i<=5; i++){
//            addUser(i + "");
//        }
//        service.addUser("1");
        addUser("1");
    }


}
