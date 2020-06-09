package com.xc.java.concurrent.pool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @Author: xc
 * @Date: 2020/6/9
 */
public class CachedThreadPoolDemo {

    public static void main(String[] args) {
        BlockingQueue<Runnable> blockingQueue = new ArrayBlockingQueue<>(100);
        //创建一个核心线程数是1,最大线程数5,空闲存活时间3秒,阻塞队列大小10,线程工厂(采用默认的一个 设置方法名),淘汰策略:直接抛出异常，这是默认策略；
        ThreadPoolExecutor cachedThreadPool = new ThreadPoolExecutor(1,
                5,
                1L,
                TimeUnit.SECONDS,
                blockingQueue,
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());
        //提交任务执行
        for (int i = 0; i <100 ; i++) {
            final int index = i ;
            cachedThreadPool.execute(()-> System.out.println(index));
        }
        //关闭线程池 (不然不会停)
        cachedThreadPool.shutdown();
    }


}
