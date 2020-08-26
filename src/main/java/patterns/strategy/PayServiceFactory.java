package patterns.strategy;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 支付接口工厂
 * @Author xc
 * @Date 2020/8/26
 */
public class PayServiceFactory {
    //存用户对于服务
    public static Map<String,PayService> map = new ConcurrentHashMap<>();

    public static PayService getPayService(String type){
        return map.get(type);
    }

    public static void register(String type, PayService payService){
        map.put(type,payService);
    }

}
