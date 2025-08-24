package com.wjf.demo.java8base.multithread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author JF
 * @created 2025/7/23 20:08
 * @description
 */
public class NaiveExceptionHandling {
    public static void main(String[] args) {
        try {
            ExecutorService executorService = Executors.newCachedThreadPool();
            executorService.execute(new ExceptionThread());
        }catch (Exception e){
            System.out.println("Exception has been handled!");
        }
    }
}
