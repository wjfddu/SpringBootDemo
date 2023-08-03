package com.wjf.demo.web.controller;

import com.wjf.demo.commonweb.vo.ResultVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试控制器
 */
@RestController
public class TestController {

    @GetMapping("/helloWorld")
    public String helloWorld(){
        return "HelloWorld";
    }

    @GetMapping("/helloWorld1")
    public void helloWorld1(){
        System.out.println("HelloWorld");
    }

    @GetMapping("/helloWorld2")
    public ResultVO helloWorld2(){
        return ResultVO.ok();
    }

    @GetMapping("/helloWorld3")
    public void helloWorld3(){
        int i = 1 / 0;
    }

}
