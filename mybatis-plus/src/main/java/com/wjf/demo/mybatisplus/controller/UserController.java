package com.wjf.demo.mybatisplus.controller;

import com.wjf.demo.mybatisplus.model.resp.UserResp;
import com.wjf.demo.mybatisplus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public List<UserResp> queryUserList(){
        List<UserResp> userResps = userService.listUser();
        return userResps;
    }

}
