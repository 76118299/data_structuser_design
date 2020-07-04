package design.singleton;

/**
 * 双重检查锁
 */
public class Mgr03 {
    private volatile static Mgr03 mgr03;
    private Mgr03() {
    }
    public static Mgr03 getInstance() {
        if (null == mgr03) { //防止多余得锁
            synchronized (Mgr03.class) {
                if (null == mgr03) {
                    mgr03 = new Mgr03();
                }
            }
        }
        return mgr03;
    }
}
