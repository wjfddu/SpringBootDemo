package com.wjf.demo.java8base.multithread;

import java.util.concurrent.ThreadFactory;

/**
 * @author JF
 * @created 2025/7/21 9:29
 * @description
 */
public class DaemonThreadFactory implements ThreadFactory {
    @Override
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable);
        thread.setDaemon(true);

        return thread;
    }
}
