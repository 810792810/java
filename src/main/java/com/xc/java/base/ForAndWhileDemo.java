package com.xc.java.base;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @Author: xc
 * @Date: 2020/6/10
 * 主要介绍循环的几种写法和退出循环的几种方式
 */
public class ForAndWhileDemo {

    @Test
    void whileDemo(){
        int i = 0;
        //while循环  表达式返回ture就是进循环, false就结束循环
        while (i <= 5){
            System.out.println(i++);
        }

        //do{}while()  不管判断表达式会不会执行,都会执行一遍循环体
        System.out.println("do while i其实已经不满足条件了,但是还是会执行一次循环体");
        do{
            System.out.println(i);
        }while(i<5);
    }

    @Test
    void forDemo(){
        int [] arr = {1,2,3,4,2};

        //for
        System.out.println("最基础的for");
        for (int i = 0; i< arr.length ; i++){
            System.out.println(arr[i]);
        }

        System.out.println("foreach");
        //foreach
        for(int value : arr){
            System.out.println(value);
        }

        //lambda 流的形式
        System.out.println("lambda 流的形式");
        Arrays.stream(arr).forEach((value)-> System.out.println(value));
    }

    //退出for,  while同理
    @Test
    void endForDemo(){
        //1. 自然结束完出去
        System.out.println("自然循环结束出去");
        for (int i = 0; i < 5; i++) {
            System.out.println(i);
        }

        //2. continue  结束循环中的一次
        System.out.println("continue 结束循环中的一次");
        for (int i = 0; i < 5; i++) {
            if (i == 2){
                continue;
            }else{
                System.out.println(i);
            }
        }

        System.out.println("continue + 标识 结束循环");
        continue1:
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.println(i + " " +j);
                if (j == 2){
                    continue continue1;
                }
            }
        }

        //结束一次for循环 break;
        System.out.println("break  结束循环");
        for (int i = 0; i < 5; i++) {
            System.out.println(i);
            if (i == 2){
                break;
            }
        }

        //跳出for循环 break  + 标识; 跳出到对应标识层   如果一个break 只会结束一层for 如果有两层for,外层还是会继续循环
        System.out.println("break + 标识 结束循环");
        break1:
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.println( i + " " + j );
                if (j == 2){
                    break break1;
                }

            }
        }

        //异常方式退出循环
        System.out.println("异常方式结束循环 ");
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println(i);
                if (i == 2){
                    throw new RuntimeException();
                }
            }
        }catch (Exception e){
            System.out.println("遇到异常了结束循环 ");
        }

        //return方式 直接返回方法
        System.out.println("return 结束循环");
        for (int i = 0; i < 5; i++) {
            System.out.println(i);
            if (i == 2){
                return;
            }
        }



    }

}
