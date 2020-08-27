package patterns.observer;

/**
 * 观察者抽象
 * @Author xc
 * @Date 2020/8/27
 */
public interface Observer {
    /**
     * 接受通知
     * @param state
     */
    void update(int state);

}
