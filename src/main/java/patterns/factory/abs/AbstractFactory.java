package patterns.factory.abs;

import patterns.factory.OS;
import patterns.factory.Software;

/**
 * 抽象工厂
 * @Author xc
 * @Date 2020/8/26
 */
public abstract class AbstractFactory {

    public abstract OS getOS(String os);
    public abstract Software getSoftware(String os);

}
