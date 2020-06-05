package com.xc.java.reflect.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author: xc
 * @Date: 2020/6/5
 * 工作日志处理代理类
 */
public class LogHandler<T>  implements InvocationHandler {

    private T target;

    public LogHandler(T target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object obj=method.invoke(target,args);
        after();
        return obj;
    }

    public void before(){
        System.out.println("上班啦...打卡成功!");
    }

    private void after(){
        System.out.println("下班啦...打开成功!");
    }
}
