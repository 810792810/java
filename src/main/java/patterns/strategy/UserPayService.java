package patterns.strategy;

import java.math.BigDecimal;

/**
 * 用户支付
 * @Author xc
 * @Date 2020/8/26
 */
public class UserPayService implements PayService {
    @Override
    public BigDecimal price(BigDecimal orderPrice) {
        return orderPrice;
    }
}
