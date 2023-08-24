package com.wjf.demo.java8base.generic.tuple;

public class TupleTest {
    static Tuple<String, Integer> f() {
        // 自动装箱将 int 转换为 Integer：
        return new Tuple<>("hi", 47);
    }
    static Tuple2<Double, String, Integer> g() {
        return new Tuple2<>(new Double(1D), "hi", 47);
    }
    public static void main(String[] args) {
        Tuple<String, Integer> ttsi = f();
        System.out.println(ttsi);
        // ttsi.a1 = "there"; // Compile error: final
        System.out.println(g());
    }
}