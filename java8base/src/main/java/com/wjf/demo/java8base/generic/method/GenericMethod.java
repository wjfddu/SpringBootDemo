package com.wjf.demo.java8base.generic.method;

import java.util.ArrayList;
import java.util.List;

/**
 * 　泛型方法：对类内部的方法进行参数化
 *
 */
public class GenericMethod {

    /**
     * 要定义一个泛型方法，需要将泛型参数列表放在返回值之前
     */
    public <T> void f(T x) {
        System.out.println(x.getClass().getName());
    }

    public static <T> List<T> makeList(T... args) {
        List<T> result = new ArrayList<>();
        for(T item : args)
            result.add(item);
        return result;
    }
    
    
    public static void main(String[] args) {
        GenericMethod gm = new GenericMethod();
        gm.f("");
        gm.f(1);
        gm.f(1.0);
        gm.f(1.0F);
        gm.f('c');
        gm.f(gm);

        makeList("1", "2");
    }
}