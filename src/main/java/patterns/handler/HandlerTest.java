package patterns.handler;

/**
 * 责任链模式
 * @Author xc
 * @Date 2020/8/31
 */
public class HandlerTest {
    public static void main(String[] args) {
        LeaderHandler leaderHandler = new LeaderHandler();
        HrHandler hrHandler = new HrHandler();
        BossHandler bossHandler = new BossHandler();

        leaderHandler.setNext(hrHandler);
        hrHandler.setNext(bossHandler);

        leaderHandler.handle(4);
    }
}
