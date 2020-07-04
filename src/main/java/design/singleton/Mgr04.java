package design.singleton;

/**
 * 静态内部类
 */
public class Mgr04 {
    private Mgr04 (){}

    private static class Mgr04Holder{
        private static Mgr04 mgr04 = new Mgr04();
    }
    public static  Mgr04 getInstance(){
        return  Mgr04Holder.mgr04;
    }
}
