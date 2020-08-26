package patterns.factory.abs;

import patterns.factory.Android;
import patterns.factory.IOS;
import patterns.factory.OS;
import patterns.factory.Software;

/**
 * @Author xc
 * @Date 2020/8/26
 */
public class OSFactory extends AbstractFactory {


    @Override
    public OS getOS(String os) {
        if ("android".equals(os)){
            return new Android();
        }else if("ios".equals(os)){
            return new IOS();
        }
        return null;
    }

    @Override
    public Software getSoftware(String os) {
        return null;
    }
}