package com.wjf.demo.java8base.generic.tuple;

/**
 * 元组（tuple），它将一组对象一起包装进了一个对象
 *
 * 元组一般无长度限制，其中的每个对象都可以是不同的类型。不过我们会指定每个元素的类型，并且保证接收方读取元素值时得到的是正确的类型。
 *
 * @param <A>
 * @param <B>
 */
public class Tuple<A, B> {
    public final A a1;
    public final B a2;

    public Tuple(A a, B b) {
        a1 = a;
        a2 = b;
    }

    public String rep() {
        return a1 + ", " + a2;
    }

    @Override
    public String toString() {
        return "(" + rep() + ")";
    }
}