package com.wjf.demo.java8base.generic.tuple;

/**
 * 长度更长的元组则可以用继承的方式创建。添加更多类型的参数很简单：
 * @param <A>
 * @param <B>
 * @param <C>
 */
public class Tuple2<A, B, C> extends Tuple<A, B> {
    public final C a3;
    public Tuple2(A a, B b, C c) {
        super(a, b);
        a3 = c;
    }
    @Override
    public String rep() {
        return super.rep() + ", " + a3;
    }
}
