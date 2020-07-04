package design.decorator;

/**
 * 具体的装饰器
 */
public class ConcreteDecorator extends Decorator {
    public ConcreteDecorator(Component component) {
        super(component);
    }
    //定义自己的装饰器逻辑
    private void decorateMethod(){
        System.out.printf("1");
    }

    /**
     * 重写父类方法
     */
    @Override
    public void cost() {
        this.decorateMethod();
        super.cost();
    }

    public static void main(String[] args) {
        //创建被装饰者
        Component component = new ConcreteCoponent();
        //第一次被装饰
        component = new ConcreteDecorator(component);
        //第二次被装饰
        component = new ConcreteDecorator(component);
        component.cost();
    }
}
