package com.wjf.demo.java8base.generic.typeerasure;

class HasF {
    public void f() {
        System.out.println("HasF.f()");
    }
}

class Manipulator<T> {
    private T obj;
    Manipulator(T x) { obj = x; }
    // Error: cannot find symbol: method f():
    public void manipulate() {
//        obj.f();
    }
}

/**
 * 要调用 f()，我们就必须帮助泛型类，为它指定边界，来告诉编译器只接受符合该边界的类型。这里复用了 extends 关键字。
 * @param <T>
 */
class Manipulator2<T extends HasF> {
    private T obj;
    Manipulator2(T x) { obj = x; }
    public void manipulate() { obj.f(); }
}

public class Manipulation {
    public static void test1(){
        HasF hf = new HasF();
        Manipulator<HasF> manipulator = new Manipulator<>(hf);
        manipulator.manipulate();
    }
    public static void test2(){
        HasF hf = new HasF();
        Manipulator2<HasF> manipulator2 = new Manipulator2<>(hf);
        manipulator2.manipulate();
    }
    public static void main(String[] args) {
        test1();
        test2();
    }
}
