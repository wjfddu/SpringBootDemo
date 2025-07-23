package com.wjf.demo.java8base.multithread;

/**
 * @author JF
 * @created 2025/7/21 10:12
 * @description
 */
public class SimpleThread extends Thread{

    public SimpleThread() {
//        start();
    }

    @Override
    public void run() {
        super.run();
    }

    public static void main(String[] args) {
        new SimpleThread().start();
    }
}
