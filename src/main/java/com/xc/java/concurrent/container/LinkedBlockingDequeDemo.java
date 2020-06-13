package com.xc.java.concurrent.container;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Author: xc
 * @Date: 2020/6/13
 * 双向阻塞队列
 * 基于链表,链表默认容量Integer.Max ,可设定大小  ,内部锁 ReentrantLock, 维护first,last.,可以当队列也用,可以拿来当栈用
 */
public class LinkedBlockingDequeDemo {

    //3种构造方法
    @Test
    void constructorDemo(){
        //创建一个容量为 Integer.MAX_VALUE 的 LinkedBlockingDeque
        LinkedBlockingDeque<Integer> deque1  = new LinkedBlockingDeque<>();
        //创建一个具有给定（固定）容量的 LinkedBlockingDeque
        LinkedBlockingDeque deque2 = new LinkedBlockingDeque(10);

        Collection<Integer> collection = new ArrayList();
        collection.add(1);
        //创建一个容量是 Integer.MAX_VALUE 的 LinkedBlockingDeque，最初包含给定 collection 的元素，元素按该 collection 迭代器的遍历顺序添加。
        LinkedBlockingDeque deque3 = new LinkedBlockingDeque(collection);
    }


    public static void main(String[] args) throws InterruptedException {

        LinkedBlockingDeque linkedBlockingDeque = new LinkedBlockingDeque();

        linkedBlockingDeque.putLast(0);
        linkedBlockingDeque.putFirst(1);
        //put -> putLast
        linkedBlockingDeque.put(2);

        System.out.println(linkedBlockingDeque);

        System.out.println("takeFirst " + linkedBlockingDeque.takeFirst());
        System.out.println("takeLast " + linkedBlockingDeque.takeLast());

        linkedBlockingDeque.push(3);
        linkedBlockingDeque.push(4);
        System.out.println(linkedBlockingDeque);
        System.out.println("pop " + linkedBlockingDeque.pop());



    }


}
