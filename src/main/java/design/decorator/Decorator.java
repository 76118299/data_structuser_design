package design.decorator;

/**
 * 抽象的装饰器
 * 继承继承构件的抽象类
 * 并聚合基础构建抽象类
 */
public abstract class Decorator extends Component {
    //聚合基础构建抽象类
    private Component component = null;

    public Decorator(Component component) {
        this.component = component;
    }

    @Override
    public void cost() {
        this.component.cost();
    }
}
