package com.wjf.demo.java8base.generic;

public class ObjectHolder {
    private Object a;
    public ObjectHolder(Object a) { this.a = a; }
    public void set(Object a) { this.a = a; }
    public Object get() { return a; }

    public static void main(String[] args) {
        ObjectHolder h2 = new ObjectHolder(new Fruit());
        Fruit a = (Fruit)h2.get();
        h2.set("Not an Fruit");
        String s = (String)h2.get();
        h2.set(1); // 自动装箱为 Integer
        Integer x = (Integer)h2.get();
    }
}