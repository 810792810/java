package patterns.factory.abs;

/**
 * @Author xc
 * @Date 2020/8/26
 */
public class AbstractFactoryTest {
    public static void main(String[] args) {
        AbstractFactory osFactory = FactoryProducer.getFactory("os");
        AbstractFactory softwareFactory = FactoryProducer.getFactory("software");

        osFactory.getOS("ios").printOS();
        osFactory.getOS("android").printOS();

        softwareFactory.getSoftware("ios").printSoftware();
        softwareFactory.getSoftware("android").printSoftware();

    }
}
