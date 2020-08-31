package patterns.singleton;

/**
 *  懒汉 + 双重检测
 * @Author xc
 * @Date 2020/8/31
 */
public class Singleton2 {
    private static volatile Singleton2 instance;

    private Singleton2(){}

    public static Singleton2 getInstance() {
        if (instance == null){
            synchronized (Singleton2.class){
                if (instance == null){
                    instance = new Singleton2();
                }
            }
        }
        return instance;
    }


    public static void main(String[] args) {
        Singleton2.getInstance();
    }
}
