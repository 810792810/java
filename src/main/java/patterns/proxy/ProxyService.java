package patterns.proxy;

/**
 * 代理服务类
 * @Author xc
 * @Date 2020/8/31
 */
public class ProxyService implements Service{
    RealService realService;
    ProxyService(RealService realService){
        this.realService = realService;
    }

    @Override
    public void method() {
        System.out.println("ProxyService 前置操作");
        realService.method();
        System.out.println("ProxyService 后置操作");
    }
}
