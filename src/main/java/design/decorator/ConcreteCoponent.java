package design.decorator;

/**
 * 具体的构件（被装饰者）
 */
public class ConcreteCoponent extends Component {
    public void cost() {
        System.out.printf("2");
    }
}
