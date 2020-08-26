package patterns.factory.method;

import patterns.factory.Android;
import patterns.factory.IOS;
import patterns.factory.OS;

/**
 * @Author xc
 * @Date 2020/8/26
 */
public class OSMethodFactory {

    static OS getIOS(){
        return new IOS();
    }

    static OS getAndroid(){
        return new Android();
    }

}
