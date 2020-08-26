package patterns.strategy;

import java.math.BigDecimal;

/**
 * 支付接口
 * @Author xc
 * @Date 2020/8/26
 */
public interface PayService {
    /**
     * 支付价格计算
     * @param orderPrice
     * @return
     */
    public BigDecimal price(BigDecimal orderPrice);
}
