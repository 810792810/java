package patterns.handler;

/**
 * Leader处理类
 * @Author xc
 * @Date 2020/8/31
 */
public class LeaderHandler extends Handler{
    @Override
    public void handle(int leaveDay) {
        if (leaveDay<=3){
            System.out.println("Leader 批准了");
        }else{
            if (getNext() !=null){
                System.out.println("Leader无法批准");
                getNext().handle(leaveDay);
            }else {
                System.out.println("请假天数过多,没人不批批准");
            }
        }
    }
}
