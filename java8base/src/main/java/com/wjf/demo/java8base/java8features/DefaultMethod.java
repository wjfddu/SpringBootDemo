package com.wjf.demo.java8base.java8features;

public interface DefaultMethod {
    default void m(){
        System.out.println("DefaultMethod...");
    }
}
