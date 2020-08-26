package patterns.factory;

import patterns.factory.OS;

/**
 * @Author xc
 * @Date 2020/8/26
 */
public class Android implements OS {
    @Override
    public void printOS() {
        System.out.println("android系统");
    }
}
