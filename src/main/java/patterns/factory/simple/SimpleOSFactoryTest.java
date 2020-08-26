package patterns.factory.simple;

import patterns.factory.OS;

/**
 * @Author xc
 * @Date 2020/8/26
 */
public class SimpleOSFactoryTest {
    public static void main(String[] args) {
        SimpleOSFactory simpleOSFactory = new SimpleOSFactory();
        OS android = simpleOSFactory.getOS("android");
        android.printOS();
        OS ios = simpleOSFactory.getOS("ios");
        ios.printOS();


    }
}
