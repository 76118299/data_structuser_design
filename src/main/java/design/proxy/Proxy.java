package design.proxy;

/**
 * 静态代理
 */
public class Proxy implements Moveable {
    private Moveable moveable;

    public Proxy(Moveable moveable) {
        this.moveable = moveable;
    }

    public void move() {
        System.out.printf("1");
        moveable.move();
        System.out.printf("2");
    }
}
