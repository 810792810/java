package com.xc.java.reflect;

import org.junit.jupiter.api.Test;

import java.lang.reflect.*;

/**
 * @Author: xc
 * @Date: 2020/6/5
 */
public class ReflectTest {

    @Test
    void testClass() throws Exception{

        //通过Class.forName
        Class clazz = Class.forName("com.xc.java.reflect.ClassDemo");
        System.out.println("通过Class.forName: " + clazz);
        //通过 类.class
        Class clazz1 = ClassDemo.class;
        System.out.println("通过 类.class: " + clazz1);

        //通过对象getClass
        Class clazz2 = new ClassDemo().getClass();
        System.out.println("通过对象getClass: " + clazz2);

        //获取类加载器
        ClassLoader classLoader = clazz.getClassLoader();
        System.out.println("类加载器classLoader: " +classLoader);

        //获取内部所有public类,接口
        Class[] classes = clazz.getClasses();
        System.out.println("公共的内部类,接口 getClasses: " + classes);

        //获取内部所有类,接口
        Class[] declaredClasses = clazz.getDeclaredClasses();
        System.out.println("所有的内部类,接口 declaredClasses: " + classes);

        //获取该类实现的接口
        Class[] interfaces = clazz.getInterfaces();
        System.out.println("所有实现的接口getInterfaces: " + classes);

        //获取类的限定类名
        String name = clazz.getName();
        System.out.println("限定类名 getName: " + name);

        //获取类的非限定类名
        String simpleName = clazz.getSimpleName();
        System.out.println("非限定类名 getSimpleName: " + simpleName);

        //获取类所在的包
        Package aPackage = clazz.getPackage();
        System.out.println("获取包 getPackage: " + aPackage);

        //获取直接父类
        Class superclass = clazz.getSuperclass();
        System.out.println("获取父类对象 getSuperclass: " + superclass);

        //父类(或解耦)转换子类
        Class subClazz = clazz.asSubclass(AbstractClassDemo.class);
        System.out.println("父类转子类 subClazz" +subClazz);

        //创建一个对象
        ClassDemo classDemo = (ClassDemo)clazz.newInstance();
        System.out.println("新建一个对象:newInstance " + classDemo);

        //getEnclosingClass(支撑匿名内部类) 和 getDeclaringClass(不支持匿名内部类) 都是内部类获取外部类.
        classDemo.testGetDeclaredClasses();
    }

    /**
     * JAVA 反射机制中，Field的getModifiers()方法返回int类型值表示该字段的修饰符。
     * 对应表如下：
     * PUBLIC: 1
     * PRIVATE: 2
     * PROTECTED: 4
     * STATIC: 8
     * FINAL: 16
     * SYNCHRONIZED: 32
     * VOLATILE: 64
     * TRANSIENT: 128
     * NATIVE: 256
     * INTERFACE: 512
     * ABSTRACT: 1024
     * STRICT: 2048
     */

    @Test
    void testField() throws Exception {
        Class clazz = ClassDemo.class;
        Object obj = clazz.newInstance();

        //获取单个属性 public
        clazz.getField("publicString");
        //获取单个属性 private
        clazz.getDeclaredField("publicString");

        //获取类的所有public属性
        Field[] fields = clazz.getFields();
        System.out.println("获取所有public 属性: ");
        for(Field field : fields){
            System.out.println(field.getModifiers() + " " + field.getType().getSimpleName() + " " +field.getName() + " " +field.get(obj));
        }

        //获取所有属性
        Field[] declaredFields = clazz.getDeclaredFields();
        System.out.println("获取所有属性: ");
        for(Field field : declaredFields){

            //设置可访问
            field.setAccessible(true);

            if("publicString".equals(field.getName())){
                //修改公共属性
                field.set(obj,"修改公共属性success");
            }else if("privateString".equals(field.getName())){
                //修改私有属性
                field.set(obj,"修改私有属性success");
            }else if("FINAL_FIELD".equals(field.getName())){
                //修改私有非静态常量
                //modifiers使修饰符的值
                Field modifiers = Field.class.getDeclaredField("modifiers");
                modifiers.setAccessible(true);
                modifiers.setInt(field, field.getModifiers()&~Modifier.FINAL);
                field.set(obj,"修改私有非静态常量success");
            }else if("STATIC_FINAL_FIELD".equals(field.getName())){
                //修改私有静态常量
                Field modifiers = Field.class.getDeclaredField("modifiers");
                modifiers.setAccessible(true);
                modifiers.setInt(field, field.getModifiers()&~Modifier.FINAL);
                field.set(obj,"修改私有静态常量success");
            }
            System.out.println(field.getModifiers() + " "
                    + field.getType().getSimpleName() + " "
                    + field.getName() + " "
                    + field.get(obj));
        }
    }

    @Test
    void testMethod() throws Exception{
        Class clazz = ClassDemo.class;
        ClassDemo classDemo = (ClassDemo) (clazz.newInstance());

        //获取所有共有方法
        Method[] methods = clazz.getMethods();
        //通过方法名称 和 ...所有参数类型
        Method thisPublicMethod = clazz.getMethod("thisPublicMethod", String.class);

        //获取方法所有throws异常
        Class[] exceptionTypes = thisPublicMethod.getExceptionTypes();

        //方法所在类
        Class<?> declaringClass = thisPublicMethod.getDeclaringClass();

        //方法参数个数
        int parameterCount = thisPublicMethod.getParameterCount();

        //返回方法所有参数类型
        Class<?>[] parameterTypes = thisPublicMethod.getParameterTypes();

        //返回结果类型
        Class<?> returnType = thisPublicMethod.getReturnType();

        //返回所有Parameter
        Parameter[] parameters = thisPublicMethod.getParameters();

        //获取所有方法
        Method[] declaredMethods = clazz.getDeclaredMethods();

        for (Method declaredMethod : declaredMethods) {
            //设置访问权限
            declaredMethod.setAccessible(true);
            //执行方法
            declaredMethod.invoke(classDemo ,new Object[declaredMethod.getParameterCount()]);
        }
    }

    @Test
    public void testAnnotation() throws Exception{
        Class clazz = ClassDemo.class;
        Object obj = clazz.newInstance();

        //获取属性
        Field[] fields = clazz.getDeclaredFields();

        //获取方法
        Method[] methods = clazz.getDeclaredMethods();

        for (Field field : fields) {
            //是否有该注解
            if (field.isAnnotationPresent(AnnotationDemo.class)) {
                //获取指定注解
                AnnotationDemo annotation = field.getAnnotation(AnnotationDemo.class);
                //获取注解值
                System.out.print("属性注解:" + annotation.value()+ "\n");
                field.setAccessible(true);
                field.set(obj,annotation.value());
            }
        }

        for (Method method : methods) {
            if (method.isAnnotationPresent(AnnotationDemo.class)) {
                AnnotationDemo annotation = method.getAnnotation(AnnotationDemo.class);
                System.out.print("方法注解值:" + annotation.value() + "\n");
            }
        }

        //获取类上所有注解
        clazz.getAnnotations();

        if (clazz.isAnnotationPresent(AnnotationDemo.class)){
            AnnotationDemo annotation = (AnnotationDemo)  clazz.getAnnotation(AnnotationDemo.class);
            System.out.println("类上注解: " + annotation.value());
        }


        Constructor constructor = clazz.getConstructor();
        //获取构造起上所有注解
        constructor.getAnnotations();

        if (constructor.isAnnotationPresent(AnnotationDemo.class)) {
            AnnotationDemo annotationDemo = (AnnotationDemo)constructor.getAnnotation(AnnotationDemo.class);
            System.out.println("构造器注解值: " + annotationDemo.value());
        }

    }
}
