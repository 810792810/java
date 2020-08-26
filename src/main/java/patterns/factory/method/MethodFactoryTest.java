package patterns.factory.method;

/**
 * @Author xc
 * @Date 2020/8/26
 */
public class MethodFactoryTest {
    public static void main(String[] args) {
        OSMethodFactory.getIOS().printOS();
        OSMethodFactory.getAndroid().printOS();
    }
}
