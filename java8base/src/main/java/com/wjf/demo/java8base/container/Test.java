package com.wjf.demo.java8base.container;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * @author JF
 * @created 2025/7/30 18:39
 * @description
 */
public class Test {
    public static void main(String[] args) {
        LinkedHashMap map = new LinkedHashMap<>();
        map.put("123", 123);
        map.forEach((o, o2) -> {});
    }
}
