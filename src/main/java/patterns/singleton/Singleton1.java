package patterns.singleton;

/**
 * 饿汉
 * @Author xc
 * @Date 2020/8/31
 */
public class Singleton1 {
    private static final Singleton1 instance = new Singleton1();

    private Singleton1(){}

    public static Singleton1 getInstance(){
        return instance;
    }


    public static void main(String[] args) {
        Singleton1.getInstance();
    }
}

