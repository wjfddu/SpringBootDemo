package com.wjf.demo.java8base.multithread;

/**
 * @author JF
 * @created 2025/7/21 9:33
 * @description
 */
public class MoreBasicThreads {

    public static void main(String[] args) {
        for (int i=0; i<5; i++){
            new Thread(new LiftOff()).start();
        }
        System.out.println("Waiting for LiftOff");
    }
}
