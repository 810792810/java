package patterns.handler;

/**
 * HR处理类
 * @Author xc
 * @Date 2020/8/31
 */
public class HrHandler extends Handler{
    @Override
    public void handle(int leaveDay) {
        if (leaveDay<=5){
            System.out.println("HR 批准了");
        }else{
            if (getNext() !=null){
                System.out.println("HR无法批准");
                getNext().handle(leaveDay);
            }else {
                System.out.println("请假天数过多,没人不批批准");
            }
        }
    }
}
