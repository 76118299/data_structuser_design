package design.proxy;

public class Proxy1 implements Moveable {
    private Moveable moveable;

    public Proxy1(Moveable moveable) {
        this.moveable = moveable;
    }

    public void move() {
        System.out.printf("4");
        moveable.move();
        System.out.printf("5");
    }

    public static void main(String[] args) {
        /**
         * 进行包装多个代理
         */
        new Proxy1(
                new Proxy(
                        new Move()
                        )
        ).move();
    }
}
