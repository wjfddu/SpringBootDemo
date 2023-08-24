package com.wjf.demo.java8base.generic;

public class GenericHolder<T> {
    private T a;
    public GenericHolder() {}
    public void set(T a) { this.a = a; }
    public T get() { return a; }

    public static void main(String[] args) {
        GenericHolder<Fruit> h3 = new GenericHolder<>();
        h3.set(new Fruit()); // 类型已检查
        Fruit a = h3.get(); // 不需要转型
        // h3.set("Not an Automobile"); // Error
        // h3.set(1); // Error
    }
}
