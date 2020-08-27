package patterns.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 主题
 * @Author xc
 * @Date 2020/8/27
 */
public class Subject {
    //维护观察者集合
    private List<Observer> observerList = new ArrayList<>();

    /**
     * 添加观察者
     * @param observer
     */
    public void add(Observer observer){
        observerList.add(observer);
    }

    /**
     * 主题状态更改
     * @param state
     */
    public void update(Integer state){
        notifyAllObserver(state);
    }

    /**
     * 通知所有观察者
     * @param state
     */
    private void notifyAllObserver(Integer state){
        for (Observer observer : observerList){
            observer.update(state);
        }
    }
}
