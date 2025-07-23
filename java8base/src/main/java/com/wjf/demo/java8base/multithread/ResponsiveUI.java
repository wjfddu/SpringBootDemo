package com.wjf.demo.java8base.multithread;

import java.io.IOException;

/**
 * @author JF
 * @created 2025/7/23 18:01
 * @description
 */
public class ResponsiveUI extends Thread{
    private static volatile double d = 1;

    public ResponsiveUI() {
        setDaemon(true);
        start();
    }

    @Override
    public void run() {
        while (true){
            d = d + (Math.PI + Math.E) / d;
        }
    }

    public static void main(String[] args) throws IOException {
        new ResponsiveUI();
        int read = System.in.read();
        System.out.println(read);
        System.out.println(d);
    }
}
