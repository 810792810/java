package patterns.observer;

/**
 * 短信观察者
 * @Author xc
 * @Date 2020/8/27
 */
public class SMSObserver implements Observer{
    @Override
    public void update(int state) {
        System.out.println("主题状态改变, 短信通知 state= " + state);
    }
}
