package patterns.handler;

/**
 * 抽象处理类
 * @Author xc
 * @Date 2020/8/31
 */
public abstract class  Handler {
    private Handler next;
    public void setNext(Handler next){
        this.next=next;
    }

    public Handler getNext(){
        return next;
    }
    //处理请求的方法
    public abstract void handle(int leaveDay);
}
