package design.adapter;

import java.lang.annotation.Target;

/**
 * 适配器模式
 */
public class Main {
    /**
     * 标准接口
     */
    interface  Target{
        public void request();
    }

    /**
     * 被适配者
     */
   static class  Adaptee {
        public void specificRquest(){
            System.out.printf("被适配者");
        }
    }

    /**
     * 接口适配器
     * 继承被适配者
     * 实现目标接口即 我们的标准接口
     */
    public static class Adapter extends Adaptee implements Target{
        public void request() {
            super.specificRquest();
        }
    }

    public static void main(String[] args) {
        Target t = new Main.Adapter();
    }

    /**
     * 对象适配器
     */
     public static class OjbectAdapter implements Target{
        private Adaptee adaptee;

        public OjbectAdapter(Adaptee adaptee) {
            this.adaptee = adaptee;
        }

        public void request() {
            adaptee.specificRquest();
         }
     }
}
