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
            threadPoolExecutor.execute(()-> {
                System.out.println(Thread.currentThread().getName() + " "+index);
            });
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

    //修改线程池的属性,以及获取一些属性和状态信息.
     @Test
     void configDemo() {
        BlockingQueue<Runnable> blockingQueue = new ArrayBlockingQueue<>(100);
        //创建一个核心线程数是2,最大线程数5,空闲存活时间3秒,阻塞队列大小10,线程工厂(采用默认的一个 设置方法名),淘汰策略:直接抛出异常，这是默认策略；
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3,
                5,
                1L,
                TimeUnit.SECONDS,
                blockingQueue,
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());
        //启动一个核心线程
         boolean b = threadPoolExecutor.prestartCoreThread();
         System.out.println("线程池活跃线程数 " + threadPoolExecutor.getActiveCount());
        //启动所有核心线程
         int i1 = threadPoolExecutor.prestartAllCoreThreads();
         System.out.println("prestartAllCoreThreads " + i1);
         System.out.println("线程池活跃线程数 " + threadPoolExecutor.getActiveCount());


         //提交任务执行
        for (int i = 0; i <100 ; i++) {
            final int index = i ;
            threadPoolExecutor.execute(()-> {
                if (index >3 ){
                    try {
                        Thread.sleep(10L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + " "+index  + " ;"+
                        " 当前队列数 " + threadPoolExecutor.getQueue().size() +
                        " 活线程总数 " + threadPoolExecutor.getActiveCount() +
                        " 当前最大线程数 " + threadPoolExecutor.getLargestPoolSize() +
                        " 当前线程池大小 " + threadPoolExecutor.getPoolSize() +
                        " 已完成任务数量 " + threadPoolExecutor.getCompletedTaskCount() +
                        " 核心线程数 " + threadPoolExecutor.getCorePoolSize() +
                        " 设置的最大线程数 " + threadPoolExecutor.getMaximumPoolSize() +
                        " 任务数 " + threadPoolExecutor.getTaskCount() +
                        " 非核心线程空闲存活时间 " + threadPoolExecutor.getKeepAliveTime(TimeUnit.SECONDS) +
                        " 饱和策略 " + threadPoolExecutor.getRejectedExecutionHandler() +
                        " 线程工厂 " + threadPoolExecutor.getThreadFactory()
                );
            });

            //可以动态修改线程池的参数 核心线程数,最大线程数,非核心线程的空闲存活时间,饱和策略,线程工厂
            if(i ==50){
                try {
                    Thread.sleep(1L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
//                System.out.println("获取队列 " + threadPoolExecutor.getQueue());
//                System.out.println("获取活线程总数 " + threadPoolExecutor.getActiveCount());
//                System.out.println("已完成任务数量 " + threadPoolExecutor.getCompletedTaskCount());
//                System.out.println("获取核心线程数 " + threadPoolExecutor.getCorePoolSize());
//                System.out.println("获取最大的线程数 " + threadPoolExecutor.getLargestPoolSize());
//                System.out.println("获取最大线程数 " + threadPoolExecutor.getMaximumPoolSize());
//                System.out.println("获取当前线程池大小 " + threadPoolExecutor.getPoolSize());
//                System.out.println("获取任务数 " + threadPoolExecutor.getTaskCount());
//                System.out.println("获取非核心线程空闲存活时间 " + threadPoolExecutor.getKeepAliveTime(TimeUnit.SECONDS));
//                System.out.println("获取饱和策略 " + threadPoolExecutor.getRejectedExecutionHandler());
//                System.out.println("获取线程工厂 " + threadPoolExecutor.getThreadFactory());

                //移除任务
                Runnable peek = threadPoolExecutor.getQueue().peek();
                if (threadPoolExecutor.remove(peek)){
                    System.out.println("移除一个任务" + peek );
                    peek.run();
                }
                threadPoolExecutor.setKeepAliveTime(5,TimeUnit.SECONDS);
                //设置工厂线程
                threadPoolExecutor.setThreadFactory(new MyThreadFactory());
                //设置饱和策略
                threadPoolExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
                //设置核心线程数
                threadPoolExecutor.setCorePoolSize(3);
                //设置最大线程数
                threadPoolExecutor.setMaximumPoolSize(4);
            }
        }
        //关闭线程池
        threadPoolExecutor.shutdown();

        //立即关闭
//        threadPoolExecutor.shutdownNow();

        if (threadPoolExecutor.isShutdown()){
            System.out.println("线程池处于状态 shutdown ");
        }
        if (threadPoolExecutor.isTerminating()){
            System.out.println("线程池处于状态 terminating ");
        }
        for(;;){
            if (threadPoolExecutor.isTerminated()){
                System.out.println("线程池处于状态 terminated ");
                break;
            }
        }
    }

}
