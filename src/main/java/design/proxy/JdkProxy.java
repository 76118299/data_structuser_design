package design.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkProxy {
    public static void main(String[] args) {
       // System.getProperties().put("jdk.proxy.ProxyGenerator.saveGeneratedFiles", "true");
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
         Move move = new Move();
        Moveable o = (Moveable) Proxy.newProxyInstance(Move.class.getClassLoader(), new Class[]{Moveable.class}, new MyInvocationHandler(move));
        o.move();

    }
}
class MyInvocationHandler implements InvocationHandler{
    private Moveable moveable;

    public MyInvocationHandler(Moveable moveable) {
        this.moveable = moveable;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object invoke = method.invoke(moveable, args);
        return invoke;
    }
}
