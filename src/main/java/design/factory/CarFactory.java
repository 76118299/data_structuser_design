package design.factory;

/**
 * 简单工厂
 */
public class CarFactory {
    public static Car create(){
        before();
        Car car = new Car();
        after();
        return car;
    }

    /**
     * 前置操作
     */
    private static void before(){

    }

    /**
     * 后置操作
     */
    private static void after(){

    }
}
