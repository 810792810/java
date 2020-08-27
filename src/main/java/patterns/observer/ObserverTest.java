package patterns.observer;

/**
 * 观察者模式
 * @Author xc
 * @Date 2020/8/27
 */
public class ObserverTest {
    public static void main(String[] args) {
        Observer sms = new SMSObserver();
        Observer mail = new MailObserver();
        Subject subject = new Subject();
        subject.add(sms);
        subject.add(mail);

        subject.update(1);
        subject.update(2);
    }
}
