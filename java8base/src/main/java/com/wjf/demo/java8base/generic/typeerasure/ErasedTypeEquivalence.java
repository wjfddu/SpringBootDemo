package com.wjf.demo.java8base.generic.typeerasure;

import java.util.ArrayList;

/**
 * 类型擦除
 */
public class ErasedTypeEquivalence {

    public static void main(String[] args) {
        Class c1 = new ArrayList<String>().getClass();
        Class c2 = new ArrayList<Integer>().getClass();
        System.out.println(c1 == c2);
    }

}
