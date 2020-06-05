package com.xc.java.reflect;

import java.lang.annotation.*;

/**
 * @Author: xc
 * @Date: 2020/6/5
 */
@Target({ElementType.CONSTRUCTOR, ElementType.METHOD, ElementType.PARAMETER, ElementType.FIELD, ElementType.ANNOTATION_TYPE,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface AnnotationDemo {

    String value() default "default";


    /**
     * @Target
     *   CONSTRUCTOR    构造器的声明
     *   FIELD	域声明（包括enum声明）
     *   LOCAL_VARIABLE	局部变量声明
     *   METHOD	方法声明
     *   PACKAGE	包声明
     *   PARAMETER	参数声明
     *   TYPE	类、接口（包括注解类型）或enum声明
     *
     * @Retention
     *       SOURCE     注解将被编译器丢弃
     *       CLASS	    注解将在class中使用，但会JVM被丢弃
     *       RUNTIME	JVM将在运行期也保存注解，因此可以根据反射获取到注解的信息 ,最常用
     * @Documented  将注解包含着Javadoc中
     *
     * @Inherited  允许子类继承父类的注解
     *
     */
}
