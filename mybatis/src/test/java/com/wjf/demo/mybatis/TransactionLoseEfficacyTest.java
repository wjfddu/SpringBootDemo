package com.wjf.demo.mybatis;

import com.wjf.demo.mybatis.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author JF
 * @created 2025/6/20 15:51
 * @description
 */
@SpringBootTest
public class TransactionLoseEfficacyTest {

    @Autowired
    private UserService userService;

    @Test
    void test() {
        userService.add5User();
    }

}
