package com.wjf.demo.mybatisplus.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.wjf.demo.mybatisplus.entity.User;
import com.wjf.demo.mybatisplus.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/list")
    public List<User> queryUserList(){
        List<User> userList = userMapper.selectList(null);

        for(User user:userList){
            System.out.println(user);
        }

        return userList;
    }

}
