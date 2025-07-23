package com.wjf.demo.java8base.multithread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author JF
 * @created 2025/7/20 22:00
 * @description
 */
public class CallableDemo {
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newCachedThreadPool();
        try {
            List<Future<String>> futureList = new ArrayList<>();
            for (int i=1; i<=10; i++){
                futureList.add(threadPool.submit(new TaskWithResult(i)));
            }
            long start = System.currentTimeMillis();
            futureList.forEach(stringFuture -> {
                try {
//                    Thread.MAX_PRIORITY
                    System.out.println(stringFuture.get());
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            });
            long end = System.currentTimeMillis();
            System.out.println(end - start);
        }finally {
            threadPool.shutdown();;
        }

    }
}
