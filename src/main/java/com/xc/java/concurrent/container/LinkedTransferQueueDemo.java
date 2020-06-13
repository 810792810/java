package com.xc.java.concurrent.container;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TimeUnit;

/**
 * @Author: xc
 * @Date: 2020/6/13
 */
public class LinkedTransferQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        LinkedTransferQueue<Integer> linkedTransferQueue = new LinkedTransferQueue();
        for (int i = 0; i < 3 ; i++) {
            new Thread(()->{
                try {
                    System.out.println(linkedTransferQueue.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
        Thread.sleep(100L);
//        linkedTransferQueue.add(0);
        // 如果至少有一位消费者在等待，则返回 true
        System.out.println("hasWaitingConsumer " + linkedTransferQueue.hasWaitingConsumer());
        //-阻塞
        // 返回等待消费者人数的估计值
        System.out.println("hasWaitingConsumer " + linkedTransferQueue.getWaitingConsumerCount());
        // 如果有线程在task或者poll,就直接返回,否者 阻塞
        linkedTransferQueue.transfer(1);
        //相对于transfer 就是不会阻塞,直接返回 false
        linkedTransferQueue.tryTransfer(2);
        //相对于tryTransfer 在上一个等待
        linkedTransferQueue.tryTransfer(3, 1L, TimeUnit.SECONDS);







    }
}
