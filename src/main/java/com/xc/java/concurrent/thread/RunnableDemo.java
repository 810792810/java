package com.xc.java.concurrent.thread;

public class RunnableDemo implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            //Thread.currentThread().getName() 获取线程名称
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }

}
