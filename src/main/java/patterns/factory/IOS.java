package patterns.factory;

import patterns.factory.OS;

/**
 * @Author xc
 * @Date 2020/8/26
 */
public class IOS implements OS {

    @Override
    public void printOS() {
        System.out.println("ios系统");
    }
}
