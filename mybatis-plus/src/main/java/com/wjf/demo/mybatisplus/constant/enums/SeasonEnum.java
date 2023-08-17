package com.wjf.demo.mybatisplus.constant.enums;

/**
 * 说明：如果存在名称之外的延伸属性应使用 enum 类型，下例中的数字就是延伸信息，表示一年中的第几个季节。
 */
public enum SeasonEnum {
    SPRING(1), SUMMER(2), AUTUMN(3), WINTER(4);
    private int seq;
    SeasonEnum(int seq) {
        this.seq = seq;
    }
    public int getSeq() {
        return seq;
    }
}
