package com.xc.java.concurrent.container;

import org.junit.jupiter.api.Test;

import java.sql.Time;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * @Author: xc
 * @Date: 2020/6/13
 * 同步队列
 * 内部没有维护容器,使用队列必须绑定一个task,这样put才会成功,无锁采用cas
 *
 * 一种阻塞队列，其中每个插入操作必须等待另一个线程的对应移除操作 ，反之亦然。
 * 同步队列没有任何内部容量，甚至连一个队列的容量都没有。
 * 不能在同步队列上进行 peek，因为仅在试图要移除元素时，该元素才存在；除非另一个线程试图移除某个元素，否则也不能（使用任何方法）插入元素；
 * 也不能迭代队列，因为其中没有元素可用于迭代。队列的头 是尝试添加到队列中的首个已排队插入线程的元素；
 * 如果没有这样的已排队线程，则没有可用于移除的元素并且 poll() 将会返回 null。
 * 对于其他 Collection 方法（例如 contains），SynchronousQueue 作为一个空 collection。此队列不允许 null 元素。
 *
 * 同步队列类似于 CSP 和 Ada 中使用的 rendezvous 信道。它非常适合于传递性设计，
 * 在这种设计中，在一个线程中运行的对象要将某些信息、事件或任务传递给在另一个线程中运行的对象，它就必须与该对象同步。
 *
 * 对于正在等待的生产者和使用者线程而言，此类支持可选的公平排序策略。
 * 默认情况下不保证这种排序。但是，使用公平设置为 true 所构造的队列可保证线程以 FIFO 的顺序进行访问。
 *
 * 此类及其迭代器实现 Collection 和 Iterator 接口的所有可选 方法。
 */
public class SynchronousQueueDemo {

    //SynchronousQueue队列  必须绑定一个消费者, 生产才会成功
    public static void main(String[] args) throws InterruptedException {
        //默认非公平,这里我设置成公平模式
        SynchronousQueue synchronousQueue = new SynchronousQueue(true);
        for (int i = 0; i < 5; i++) {
            final int index = i;
            new Thread(()->{
                try {
                    System.out.println(Thread.currentThread() + " 生产产品"+ index );
                    synchronousQueue.put(index);
                    System.out.println(Thread.currentThread() + " 的产品"+ index +"已被消费");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }

        Thread.sleep(100L);
        new Thread(()->{
            try {
                for (int i = 0; i < 5; i++) {
                    System.out.println("消费产品: " + synchronousQueue.take());
                    Thread.sleep(10L);
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }


    @Test
    void offerAndPollDemo() throws InterruptedException {
        SynchronousQueue synchronousQueue = new SynchronousQueue();

        System.out.println("offer " + synchronousQueue.offer(0));
        System.out.println("poll " + synchronousQueue.poll());

        new Thread(()->{
            try {
                System.out.println("poll + timeout : " + synchronousQueue.poll(1L, TimeUnit.SECONDS));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
//        Thread.sleep(2000L);
        boolean offer = synchronousQueue.offer(1, 1L, TimeUnit.SECONDS);

        System.out.println("offer +timeout :" + offer);

    }

}
