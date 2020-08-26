package patterns.strategy;

import java.math.BigDecimal;

/**
 * vip支付
 * @Author xc
 * @Date 2020/8/26
 */
public class VipPayService implements PayService {
    @Override
    public BigDecimal price(BigDecimal orderPrice) {
        return orderPrice.multiply(new BigDecimal("0.8"));
    }
}
