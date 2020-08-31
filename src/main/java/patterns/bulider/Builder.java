package patterns.bulider;

/**
 * 抽象建造者
 * @Author xc
 * @Date 2020/8/31
 */
public abstract class Builder {
    protected Product product = new Product();

    public abstract Builder id(Integer id);
    public abstract Builder name(String name);

    public Product builder(){
        return product;
    }


}
