package patterns.builder;

/**
 * 具体建造者
 * @Author xc
 * @Date 2020/8/31
 */
public class ConcreteBuilder extends Builder {
    @Override
    public Builder id(Integer id) {
        product.setId(id);
        return this;
    }

    @Override
    public Builder name(String name) {
        product.setName(name);
        return this;
    }
}
