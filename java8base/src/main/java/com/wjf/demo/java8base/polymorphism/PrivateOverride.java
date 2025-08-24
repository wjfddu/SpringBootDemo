package com.wjf.demo.java8base.polymorphism;

/**
 * @author JF
 * @created 2025/8/3 19:09
 * @description
 */
public class PrivateOverride {

    private void f(){
        System.out.println("private f()");
    }

    public static void main(String[] args) {
        PrivateOverride po = new Derived();
        po.f();
    }
}
class Derived extends PrivateOverride{
    public void f(){
        System.out.println("public f()");
    }
}