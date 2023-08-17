package com.wjf.demo.mybatisplus.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;


@Data
@TableName("user")
public class UserEntity {
    private Integer id;
    private String name;
}
