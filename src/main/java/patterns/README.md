# java
1.建造者模式 
    包 builder
    4个成员:
        Builder 抽象建造者
        ConcreteBuilder: 具体建造者
        Product: 产品
        Director: 指挥者
    例子: springboot中 SpringApplicationBuilder 构建 SpringApplication

2.单例模式
    包 singleton
    Singleton1 饿汉式
    Singleton2 懒汉式(双重检测)
    Singleton3 枚举方式
    
3.工厂模式
    包factory
        abs包, 抽象工厂模式
        method包, 工厂方法模式
        simple包, 简单工厂模式
4.观察者模式
    包 observer
    成员
        Observer 抽象观察者
        SMSObserver 短信观察者
        MailObserver 邮件观察者
        Subject 主题
5.策略模式
    包 strategy
    成员
        payService      抽象策略类 定义支付方法
        UserPayService  具体策略类 用户支付算法实现
        VipPayService   具体策略类 vip支付算法实现
        PayServiceFactory   策略模式+工厂模式,实现消除if-else

6.代理模式
    包 proxy
    成员
        Service         抽象服务,定义方法
        RealService     被代理类
        ProxyService    代理类
        
7.责任链模式
    包 handler
    成员
        Handler         抽象处理类
        BossHandler     boss处理类
        HrHandler       hr处理类
        LeaderHandler   leader处理类
        