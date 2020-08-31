package patterns.proxy;

/**
 * 代理模式
 * @Author xc
 * @Date 2020/8/31
 */
public class ProxyTest {
    public static void main(String[] args) {
        RealService realService = new RealService();
        ProxyService proxyService = new ProxyService(realService);
        realService.method();
        System.out.println("------------------------------");
        proxyService.method();
    }
}
