package design.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibPorxy {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Test.class);//父类
        enhancer.setCallback(new TestMethodInterceptor());
        Test t = (Test) enhancer.create();
        t.move();

    }
}

class Test {
    public void  move(){
        System.out.printf("11");
    }
}

/**
 * 创建代理业务类
 */
class  TestMethodInterceptor implements MethodInterceptor{

    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.printf("11");
       return   methodProxy.invokeSuper(o,objects);

    }
}