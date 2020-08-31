package patterns.bulider;

/**
 * 建造者模式.
 * 4个成员:
 *  Builder 抽象建造者
 *  ConcreteBuilder: 具体建造者
 *  Product: 产品
 *  Director: 指挥者
 * @Author xc
 * @Date 2020/8/31
 */
public class BuilderTest {

    public static void main(String[] args) {
        Builder builder = new ConcreteBuilder();
        //通过builder,自定义组装产品Product.
        Product product = builder.name("自定义产品").builder();
        System.out.println(product);

        //通过指挥者Director指定Builder来组装出产品Product.
        Product construct = new Director(builder).construct();
        System.out.println(construct);
    }
}
