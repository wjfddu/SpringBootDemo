package com.wjf.demo.java8base.java8features;

@FunctionalInterface
public interface DefaultMethod {

    void A();

//    void B();

    boolean equals(Object obj);

    default void defaultMethod(){
        System.out.println("defaultMethod...");
    }
}
