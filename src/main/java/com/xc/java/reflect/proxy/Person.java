package com.xc.java.reflect.proxy;

/**
 * @Author: xc
 * @Date: 2020/6/5
 */
public class Person implements Job {
    private String name;

    Person(String name){
        this.name = name;
    }
    @Override
    public void work() {
        System.out.println(name + " 上班开始写bug了");
    }
}
