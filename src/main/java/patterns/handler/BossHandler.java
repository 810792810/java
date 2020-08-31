package patterns.handler;

/**
 * BOSS处理类
 * @Author xc
 * @Date 2020/8/31
 */
public class BossHandler extends Handler{
    @Override
    public void handle(int leaveDay) {
        if (leaveDay<=30){
            System.out.println("BOSS 批准了");
        }else{
            if (getNext() !=null){
                getNext().handle(leaveDay);
            }else {
                System.out.println("请假天数过多,没人不批批准");
            }
        }
    }
}
