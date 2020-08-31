package patterns.builder;

/**
 * 指挥者
 * @Author xc
 * @Date 2020/8/31
 */
public class Director {
    private Builder builder;

    public Director(Builder builder){
        this.builder=builder;
    }

    //产品构建与组装方法
    public Product construct(){
        builder.name("Director构建产品");
        builder.id(1);
        return builder.builder();
    }
}
