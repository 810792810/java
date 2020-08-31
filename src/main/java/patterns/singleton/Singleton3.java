package patterns.singleton;

/**
 * 枚举
 * @Author xc
 * @Date 2020/8/31
 */
public enum  Singleton3 {
    INSTANCE;

    public void method(){
    }

    public static void main(String[] args) {
        Singleton3.INSTANCE.method();
    }
}
