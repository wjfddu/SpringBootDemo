package com.wjf.demo.java8base.generic.method;

import com.wjf.demo.java8base.generic.tuple.Tuple;
import com.wjf.demo.java8base.generic.tuple.Tuple2;

public class TupleTest2 {

    public static <A, B> Tuple<A, B> tuple(A a, B b) {
        return new Tuple<>(a, b);
    }

    public static <A, B, C> Tuple2<A, B, C> tuple(A a, B b, C c) {
        return new Tuple2<>(a, b, c);
    }

    static Tuple<String, Integer> f() {
        return tuple("hi", 47);
    }

    static Tuple2<Double, String, Integer> g() {
        return tuple(new Double(1D), "hi", 47);
    }

    public static void main(String[] args) {
        Tuple<String, Integer> ttsi = f();
        System.out.println(ttsi);
        System.out.println(g());
    }
}
