package design.singleton;

public class Mgr02 {
    private Mgr02(){}
    private static Mgr02  mgr02 = null;

    public static synchronized Mgr02 getInstance(){
        if(mgr02 == null){
            mgr02 = new Mgr02();
        }
        return  mgr02;
    }
}
