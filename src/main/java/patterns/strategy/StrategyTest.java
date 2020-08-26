package patterns.strategy;

import java.math.BigDecimal;

/**
 * 策略模式
 * @Author xc
 * @Date 2020/8/26
 */
public class StrategyTest {
    public static void main(String[] args) {
        PayService payService = new UserPayService();
        System.out.println("一般用户的价格 " + payService.price(new BigDecimal("1")));

        payService = new VipPayService();
        System.out.println("vip用户的价格 " + payService.price(new BigDecimal("1")));
    }
}
