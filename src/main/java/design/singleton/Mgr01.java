package design.singleton;

public class Mgr01 {
    private static Mgr01 mgr01 = new Mgr01();
    private  Mgr01(){}

    public static Mgr01 getInstance(){
         return mgr01;
    }
}
