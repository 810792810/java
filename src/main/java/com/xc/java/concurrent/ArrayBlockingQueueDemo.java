package com.xc.java.concurrent;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @Author: xc
 * @Date: 2020/6/12
 */
public class ArrayBlockingQueueDemo {

    //3种构造方法
    @Test
    void constructorDemo(){
        //队列大小100,默认使用非公平锁
        ArrayBlockingQueue<Integer> arrayBlockingQueue1 = new ArrayBlockingQueue(100);

        //队列大小100,并且指定锁的是公平还是非给公平.   true公平 false非公平
        ArrayBlockingQueue<Integer> arrayBlockingQueue2 = new ArrayBlockingQueue(100,true);

        //大小100,内部使用非公平锁, 并且以collection初始化ArrayBlockingQueue
        Collection<Integer> collection = new ArrayList();
        collection.add(1);
        ArrayBlockingQueue<Integer> arrayBlockingQueue3 = new ArrayBlockingQueue(100,false,collection);
    }

    //add(E e) 将指定的元素插入到此队列的尾部（如果立即可行且不会超过该队列的容量），在成功时返回 true，如果此队列已满，则抛出 IllegalStateException。
    @Test
    void addDemo()  {
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue(3);

        //add 超过队列大小后,抛 IllegalStateException
        try {
            for (int i = 0; i <10 ; i++) {
                queue.add(i);
            }
        }catch (IllegalStateException e){
            e.printStackTrace();
        }
        System.out.println("add" + queue);
    }

    //offer(E e) 将指定的元素插入到此队列的尾部（如果立即可行且不会超过该队列的容量），在成功时返回 true，如果此队列已满，则返回 false。
    //offer(E e, long timeout, TimeUnit unit) 将指定的元素插入此队列的尾部，如果该队列已满，则在到达指定的等待时间之前等待可用的空间。  可响应中断
    @Test
    void offerDemo(){
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue(3);

        //offer 将指定的元素插入到此队列的尾部（如果立即可行且不会超过该队列的容量），在成功时返回 true，如果此队列已满，则返回 false。
        for (int i = 0; i <10 ; i++) {
            queue.offer(i);
        }
        System.out.println("offer1 " + queue);

        queue.clear();
        //offer 将指定的元素插入此队列的尾部，如果该队列已满，则在到达指定的等待时间之前等待可用的空间。  可响应中断
        for (int i = 0; i <10 ; i++) {
            try {
                queue.offer(i,1L, TimeUnit.SECONDS);
                if (i==5){
                    queue.clear();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("offer2 " + queue);

    }

    //put  将指定的元素插入此队列的尾部，如果该队列已满，则等待可用的空间。 可响应中断
    @Test
    void putDemo(){
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue(3);
        //put  将指定的元素插入此队列的尾部，如果该队列已满，则等待可用的空间。 可响应中断
        for (int i = 0; i < 5 ; i++) {
            try {
                //队列满会阻塞
                queue.put(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //peek 获取但不移除此队列的头；如果此队列为空，则返回 null
    @Test
    void peekDemo(){
        ArrayBlockingQueue<Integer> queue = this.newInstance();
        for (int i = 0; i < 10; i++) {
            System.out.println(queue.peek());
        }


    }

    //poll() 获取并移除此队列的头，如果此队列为空，则返回 null。
    //poll(long timeout, TimeUnit unit) 获取并移除此队列的头部，在指定的等待时间前等待可用的元素（如果有必要）。
    @Test
    void pollDemo(){
        ArrayBlockingQueue<Integer> queue = this.newInstance();
        for (int i = 0; i < 10 ; i++) {
            System.out.println(queue.poll());
        }

        System.out.println("poll + 等待时间");
        queue = this.newInstance();
        for (int i = 0; i < 10 ; i++) {
            try {
                System.out.println(queue.poll(1L,TimeUnit.SECONDS));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    //task() 获取并移除此队列的头部，在元素变得可用之前一直等待（如果有必要）。
    @Test
    void taskDemo(){
        ArrayBlockingQueue<Integer> queue = this.newInstance();
        for (int i = 0; i < 10; i++) {
            try {
                //队列空了会阻塞
                System.out.println(queue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //一些队列信息获取
    @Test
    void baseDemo(){
        ArrayBlockingQueue<Integer> queue = this.newInstance();

        //如果此队列包含指定的元素，则返回 true。
        boolean contains = queue.contains(2);
        System.out.println("是否包含2这个元素" + contains );
        //remove -> poll
        queue.remove();

        //队尾遍历到队头 比对删除
        queue.remove(1);

        //清空内部数组   put索引赋值给task索引
        queue.clear();

        //移除此队列中所有可用的元素，并将它们添加到给定 collection 中。
        queue = this.newInstance();
        Collection<Integer> collection = new ArrayList<>();
        queue.drainTo(collection);
        System.out.println("drainTo之后 collection "+ collection);
        System.out.println("drainTo之后 queue "+ queue);

        //addAll  -> add
        queue = this.newInstance();
        queue.drainTo(collection,2);
        System.out.println("drainTo max 2 之后 collection "+ collection);
        System.out.println("drainTo max 2 之后 queue "+ queue);


        //返回在无阻塞的理想情况下（不存在内存或资源约束）此队列能接受的其他元素数量。  也就是空闲大小
        int i = queue.remainingCapacity();
        System.out.println("remainingCapacity" + i);

        //当前队列含元素大小
        int size = queue.size();
        System.out.println("size " + size);

        //迭代器
        Iterator<Integer> iterator = queue.iterator();
        System.out.println("迭代器循环: ");
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }


    ArrayBlockingQueue<Integer> newInstance(){
        Collection<Integer> initCollection = new ArrayList();
        initCollection.add(1);
        initCollection.add(2);
        initCollection.add(3);
        return new ArrayBlockingQueue(3,false,initCollection);
    }
}
