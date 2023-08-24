package com.wjf.demo.java8base.generic;

class Fruit {

}

public class FruitHolder {
    private Fruit a;
    public FruitHolder(Fruit a) { this.a = a; }
    Fruit get() { return a; }
}