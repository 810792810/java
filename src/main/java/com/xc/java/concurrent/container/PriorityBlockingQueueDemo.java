package com.xc.java.concurrent.container;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @Author: xc
 * @Date: 2020/6/12
 * 优先级队列
 * 内部基于数组实现,默认大小11,自动扩容(Integer最大值-8 某些虚拟机头信息),内部非公平锁,compareTo()实现取数据顺序,同优先级顺序不确定
 *
 * 通过poll ,task 才有优先级获取元素. 同优先级顺序不确定 (遍历比较 compareTo), 自动扩容
 * 一个无界阻塞队列，它使用与类 PriorityQueue 相同的顺序规则，并且提供了阻塞获取操作。
 * 虽然此队列逻辑上是无界的，但是资源被耗尽时试图执行 add 操作也将失败（导致 OutOfMemoryError）。
 * 此类不允许使用 null 元素。依赖自然顺序的优先级队列也不允许插入不可比较的对象（这样做会导致抛出 ClassCastException）。
 *
 * 此类及其迭代器可以实现 Collection 和 Iterator 接口的所有可选 方法。
 * iterator() 方法中提供的迭代器并不 保证以特定的顺序遍历 PriorityBlockingQueue 的元素。
 * 如果需要有序地进行遍历，则应考虑使用 Arrays.sort(pq.toArray())。
 * 此外，可以使用方法 drainTo 按优先级顺序移除 全部或部分元素，并将它们放在另一个 collection 中。
 *
 * 在此类上进行的操作不保证具有同等优先级的元素的顺序。
 * 如果需要实施某一排序，那么可以定义自定义类或者比较器，比较器可使用修改键断开主优先级值之间的联系。
 * 例如，以下是应用先进先出 (first-in-first-out) 规则断开可比较元素之间联系的一个类。要使用该类，
 * 则需要插入一个新的 FIFOEntry(anEntry) 来替换普通的条目对象。
 */
public class PriorityBlockingQueueDemo {

    //4种构造方法
    @Test
    void constructorDemo(){
        //用默认的初始容量 (11) 创建一个 PriorityBlockingQueue，并根据元素的自然顺序对其元素进行排序。
        PriorityBlockingQueue<Integer> PriorityBlockingQueue1  = new PriorityBlockingQueue<>();

        //使用指定的初始容量创建一个 PriorityBlockingQueue，并根据元素的自然顺序对其元素进行排序。
        PriorityBlockingQueue<Integer> PriorityBlockingQueue2 = new PriorityBlockingQueue<>(10);

        Collection<Integer> collection = new ArrayList();
        collection.add(1);
        //创建一个包含指定 collection 元素的 PriorityBlockingQueue。
        PriorityBlockingQueue<Integer> PriorityBlockingQueue3 = new PriorityBlockingQueue<>(collection);

        //使用指定的初始容量创建一个 PriorityBlockingQueue，并根据指定的比较器对其元素进行排序。
        PriorityBlockingQueue<Integer> PriorityBlockingQueue4 = new PriorityBlockingQueue<Integer>(10 , (a,  b)->  {return a.compareTo(b);}  );
    }

    //add(E e) -> offer 将指定元素插入此优先级队列。
    @Test
    void addDemo()  {
        PriorityBlockingQueue<Integer> queue = new PriorityBlockingQueue<>(3);
        //add 超过队列大小后,抛 IllegalStateException
        try {
            for (int i = 0; i <10 ; i++) {
                queue.add(i);
            }
            queue.add(128);
            queue.add(128);
        }catch (IllegalStateException e){
            e.printStackTrace();
        }
        System.out.println("add" + queue);

    }

    //offer(E e) 将指定元素插入此优先级队列。 (会动态扩容)
    //offer(E e, long timeout, TimeUnit unit) 将指定元素插入此优先级队列。，则在到达指定的等待时间之前等待可用的空间。  可响应中断
    @Test
    void offerDemo(){
        PriorityBlockingQueue<Integer> queue = new PriorityBlockingQueue<>(3);

        //offer 将指定的元素插入到此队列的尾部（如果立即可行且不会超过该队列的容量），在成功时返回 true，如果此队列已满，则返回 false。
        for (int i = 0; i <10 ; i++) {
            queue.offer(i);
        }
        System.out.println("offer1 " + queue);

        queue.clear();
        //offer 将指定元素插入此优先级队列，  直接调用offer(e) 没有等待
        for (int i = 0; i <10 ; i++) {
            queue.offer(i,1L, TimeUnit.SECONDS);
        }
        System.out.println("offer2 " + queue);

    }

    //peek  获取但不移除此队列的头；如果此队列为空，则返回 null。
    @Test
    void peekDemo(){
        PriorityBlockingQueue<Integer> queue = this.newInstance();
        for (int i = 0; i < 10; i++) {
            System.out.println(queue.peek());
        }


    }

    //poll() 获取并移除此队列的头，如果此队列为空，则返回 null。
    //poll(long timeout, TimeUnit unit) 获取并移除此队列的头部，在指定的等待时间前等待可用的元素（如果有必要）。
    @Test
    void pollDemo(){
        PriorityBlockingQueue<Integer> queue = this.newInstance();
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
        PriorityBlockingQueue<Integer> queue = this.newInstance();
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
        PriorityBlockingQueue<Integer> queue = this.newInstance();

        //如果此队列包含指定的元素，则返回 true。
        boolean contains = queue.contains(2);
        System.out.println("是否包含2这个元素" + contains );
        //remove -> poll
        queue.remove();

        //从队列中移除指定元素的单个实例（如果存在）。
        queue.remove(1);

        //清空内部数组   put索引赋值给task索引
        queue.clear();

        //移除此队列中所有可用的元素，并将它们添加到给定 collection 中。
        queue = this.newInstance();
        Collection<Integer> collection = new ArrayList<>();
        queue.drainTo(collection);
        System.out.println("drainTo之后 collection "+ collection);
        System.out.println("drainTo之后 queue "+ queue);


        queue = this.newInstance();
        queue.drainTo(collection,2);
        System.out.println("drainTo max 2之后 collection "+ collection);
        System.out.println("drainTo max 2之后 queue "+ queue);


        // 总是返回 Integer.MAX_VALUE，因为 PriorityBlockingQueue 没有容量限制。
        int i = queue.remainingCapacity();
        System.out.println("remainingCapacity " + i);

        //当前队列含元素大小
        int size = queue.size();
        System.out.println("size " + size);

        //迭代器 不会遵循优先级顺序
        Iterator<Integer> iterator = queue.iterator();
        System.out.println("迭代器循环: ");
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }


    PriorityBlockingQueue<Integer> newInstance(){
        Collection<Integer> initCollection = new ArrayList();
        initCollection.add(1);
        initCollection.add(2);
        initCollection.add(3);
        return new PriorityBlockingQueue(initCollection);
    }
}
