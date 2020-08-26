package patterns.factory.simple;

import patterns.factory.Android;
import patterns.factory.IOS;
import patterns.factory.OS;

/**
 * @Author xc
 * @Date 2020/8/26
 */
public class SimpleOSFactory {

    OS getOS(String model){
        if ("android".equals(model)){
            return new Android();
        }else if("ios".equals(model)){
            return new IOS();
        }
        return null;
    }

}
