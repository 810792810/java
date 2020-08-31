package patterns.proxy;

/**
 * 实际服务类
 * @Author xc
 * @Date 2020/8/31
 */
public class RealService implements Service {
    @Override
    public void method() {
        System.out.println("RealService ...");
    }
}
