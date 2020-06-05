package com.xc.java.reflect;

/**
 * @Author: xc
 * @Date: 2020/6/5
 */
@AnnotationDemo
public class ClassDemo extends AbstractClassDemo implements InterfaceDemo {

    private static String staticField ;

    private final String FINAL_FIELD = "final_field";

    private static final  String STATIC_FINAL_FIELD = "static_final_field";

    private int id;

    private String privateString;

    protected Integer protectedInteger;

    public String publicString;

    @AnnotationDemo(value = "属性")
    private String name;

    @AnnotationDemo
    private String def;

    @AnnotationDemo(value = "一般方法")
    public String setName(String name){
        return name;
    }


    @AnnotationDemo(value = "构造器")
    public ClassDemo(){

    }


    public String thisPublicMethod(String str) throws ClassCastException,Exception{
        System.out.println("thisPublicMethod " +str);
        return str;
    }

    private static void staticPrivateMethod(String str,String str2){
        System.out.println("staticPrivateMethod " + str +" " +str2);
    }

    @Override
    public void absMethod() {
        System.out.println("absMethod");
    }

    @Override
    public void interfaceMethod() {
        System.out.println("interfaceMethod");
    }

    public void testGetDeclaredClasses(){
        new ClassDemo2().instance().pr();
    }


    public class ClassDemo2{
        public void pr(){

        }

        public ClassDemo2 instance() {
            //匿名内部类
            return new ClassDemo2() {
                @Override
                public void pr(){
                    System.out.println("getDeclaredClasses: " + this.getClass().getDeclaringClass());
                    System.out.println("getEnclosingClass " + this.getClass().getEnclosingClass());
                }
            };
        }

    }

    private class ClassDemo3{

    }

    private static class ClassDemo4{

    }

    public interface InterFace2{

    }
}


