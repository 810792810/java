package com.xc.java.concurrent.pool;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @Author: xc
 * @Date: 2020/6/9
 */
public class ThreadPoolExecutorDemo {

    //线程池 + runnable  无返回结果
    @Test
    void runnableDemo(){
        BlockingQueue<Runnable> blockingQueue = new ArrayBlockingQueue<>(100);
        //创建一个核心线程数是2,最大线程数5,空闲存活时间3秒,阻塞队列大小10,线程工厂(采用默认的一个 设置方法名),淘汰策略:直接抛出异常，这是默认策略；
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2,
                5,
                1L,
                TimeUnit.SECONDS,
                blockingQueue,
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());
        //提交任务执行
        for (int i = 0; i <100 ; i++) {
            final int index = i ;
            threadPoolExecutor.execute(()-> System.out.println(index));
        }
        //关闭线程池 (不然不会停)
        threadPoolExecutor.shutdown();
    }

    //线程池 + callable + Future 获取线程执行结果
    @Test
    void callableDemo(){
        BlockingQueue<Runnable> blockingQueue = new ArrayBlockingQueue<>(100);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2,
                5,
                1L,
                TimeUnit.SECONDS,
                blockingQueue,
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());
        //结果集
        List<Future<Integer>> resultList = new ArrayList<Future<Integer>>();

        Future<Integer> future;
        for (int i = 0; i <100 ; i++) {
            final int index = i ;
           future = threadPoolExecutor.submit(() -> {
               return index;
           });
           resultList.add(future);
        }

        //遍历结果集 ,获取结果未完成的阻塞
        resultList.forEach( f -> {
            try {
                System.out.println(f.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });

        //关闭线程池 (不然不会停)
        threadPoolExecutor.shutdown();
    }

}
