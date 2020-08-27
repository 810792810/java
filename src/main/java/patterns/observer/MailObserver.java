package patterns.observer;

/**
 * 邮件观察者
 * @Author xc
 * @Date 2020/8/27
 */
public class MailObserver implements Observer {
    @Override
    public void update(int state) {
        System.out.println("主题状态改变, 邮件通知 state=" + state);
    }
}
