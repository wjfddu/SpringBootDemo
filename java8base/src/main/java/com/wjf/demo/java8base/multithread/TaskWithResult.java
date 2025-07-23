package com.wjf.demo.java8base.multithread;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * @author JF
 * @created 2025/7/20 21:58
 * @description
 */
public class TaskWithResult implements Callable<String> {

    private int id;

    public TaskWithResult(int id) {
        this.id = id;
    }

    @Override
    public String call() throws Exception {
//        Thread.sleep(id * 1000);
        TimeUnit.SECONDS.sleep(id);
        return  Thread.currentThread().getName() + "[id=" + id + "]";
    }
}
