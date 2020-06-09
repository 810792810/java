package com.xc.java.concurrent.thread;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/**
 * @Author: xc
 * @Date: 2020/6/7
 */
public class ThreadTest {
    /**
     * 线程执行靠的是 Thread对象的 start() 方法 ,运行的内容是run()的方法
     * 线程创建的方式
     *  1.继承Thread
     *  2.实现Runnable
     */

    @Test
    void test1(){
        //1. 通过继承Thread
        Thread thread1 = new ThreadDemo();

        //2.通过实现Runnable接口 , 然后放到Thread中
        Runnable runnableDemo = new RunnableDemo();
        Thread thread2 = new Thread(runnableDemo);

        //我们可以给线程设置名字
        thread1.setName("ThreadDemo ");
        thread2.setName("RunnableDemo ");

        //线程启动  同个线程不能多次启动 因为threadStatus状态已经变了会抛异常
        thread1.start();
        thread2.start();

        //一般方法调用 (通过线程名称可以看出)
        thread1.run();
        thread2.run();
    }

    /**
     * Thread 方法介绍
     */
    @Test
    void test2(){
        Thread thread = new Thread();
        //获取当前运行线程对象
        System.out.println("线程名 " + Thread.currentThread().getName());

        //当非守护线程停止,守护线程才停止.     比如gc
        //设置守护线程 true是守护线程
        thread.setDaemon(true);
        System.out.println("main.isDaemon - " +  Thread.currentThread().isDaemon());
        System.out.println("thread.isDaemon - " +  thread.isDaemon());

        //线程优先级 默认5  范围1-10 ,10优先级最高 (设置了优先级 不过也是随机执行的)
        System.out.println("main默认优先级"+ Thread.currentThread().getPriority());
        Thread.currentThread().setPriority(6);
        System.out.println("main设置后优先级"+ Thread.currentThread().getPriority());

        System.out.println("活动线程数: activeCount " + Thread.activeCount());

        //isAlive判断一个程序是否存活 (就绪,运行,阻塞 都是存活的)
        System.out.println("判断程序是否存活main " + Thread.currentThread().isAlive());
        System.out.println("判断程序是否存活thread " + thread.isAlive());

        //sleep 睡眠1000毫秒
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //之前网上看到的段子: 睡眠排序法  (请勿模仿)
    public static void main(String[] args) {
        Integer [] arr = {1,2,9,3,30,10,50,20,60};
        for (int i : arr){
            final int value = i;
            new Thread(()->{
                try {
                    Thread.sleep(value * 10);
                    System.out.println(value);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }


    //todo 线程通信- yield  join  sleep  wait  notify notifyAll  interrupt


}
