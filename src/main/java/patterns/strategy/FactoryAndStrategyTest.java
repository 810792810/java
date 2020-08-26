package patterns.strategy;

import java.math.BigDecimal;

/**
 * 工厂模式+策略模式 消除if-else
 * @Author xc
 * @Date 2020/8/26
 */
public class FactoryAndStrategyTest {
    public static void main(String[] args) {
        PayServiceFactory.register("user",new UserPayService());
        PayServiceFactory.register("vip",new VipPayService());

        //消除了代码中的if-else,实际项目中用户类型从数据库中得到
        System.out.println(PayServiceFactory.getPayService("user").price(new BigDecimal("1")));;
        System.out.println(PayServiceFactory.getPayService("vip").price(new BigDecimal("1")));;


    }
}
