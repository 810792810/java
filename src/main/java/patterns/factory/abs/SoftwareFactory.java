package patterns.factory.abs;

import patterns.factory.AndroidSoftware;
import patterns.factory.IOSSoftware;
import patterns.factory.OS;
import patterns.factory.Software;

/**
 * @Author xc
 * @Date 2020/8/26
 */
public class SoftwareFactory extends AbstractFactory {


    @Override
    public OS getOS(String os) {
        return null;
    }

    @Override
    public Software getSoftware(String os) {
        if ("android".equals(os)){
            return new AndroidSoftware();
        }else if("ios".equals(os)){
            return new IOSSoftware();
        }
        return null;
    }
}
