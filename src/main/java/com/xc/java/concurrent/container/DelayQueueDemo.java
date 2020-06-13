package com.xc.java.concurrent.container;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/**
 * @Author: xc
 * @Date: 2020/6/13
 * 基于PriorityBlockingQueue实现的延迟队列(无界),元素需实现Delay接口,指定过期时间
 */
public class DelayQueueDemo {
    //两种构造方法
    @Test
    void constructorDemo(){
        //创建一个容量为 Integer.MAX_VALUE 的 DelayQueue。
        DelayQueue<Message> delayQueue1  = new DelayQueue<>();

        Collection<Message> collection = new ArrayList();
        collection.add(new Message(10L,"消息内容"));
        //创建一个容量为 Integer.MAX_VALUE 的 DelayQueue，最初包含给定 collection 的元素，以该 collection 迭代器的遍历顺序添加。
        LinkedBlockingDeque<Message> delayQueue2 = new LinkedBlockingDeque(collection);
    }

    public static void main(String[] args) throws InterruptedException {
        DelayQueue<Message> queue = new DelayQueue<>();
        queue.offer(new Message(100L,"消息1"));
        queue.offer(new Message(3000L,"消息2"));
        queue.offer(new Message(40L,"消息3"));
        queue.offer(new Message(150L,"消息4"));
        queue.offer(new Message(30L,"消息5"));

        for (;queue.size()>0;){
            System.out.println(queue.take());
        }
    }
}
//延迟队列元素实现Delayed
class Message implements Delayed {

    private Long expire;

    private Long delayTime;

    private String content;

    public Long getExpire() {
        return expire;
    }

    public Message(Long delayTime, String content) {
        this.delayTime = delayTime;
        this.content = content;
        this.expire = delayTime + System.currentTimeMillis();
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(this.expire-System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        return (int)(this.expire - ((Message)o).getExpire());
    }

    @Override
    public String toString() {
        return "Message{" +
                "expire=" + expire +
                ", delayTime=" + delayTime +
                ", content='" + content + '\'' +
                '}';
    }
}
