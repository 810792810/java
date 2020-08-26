package patterns.factory.abs;

/**
 * @Author xc
 * @Date 2020/8/26
 */
public class FactoryProducer {

    public static AbstractFactory getFactory(String factory){
        if("os".equals(factory)){
            return new OSFactory();
        } else if("software".equals(factory)){
            return new SoftwareFactory();
        }
        return null;
    }
}
