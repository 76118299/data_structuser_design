package design.abstractfactory;

public class Main {
    public static void main(String[] args) {
        /**
         * 创建现代工厂
         */
        AbstractFactory magicFactory = new MagicFactory();
       Food bread =  magicFactory.createFood();

        /**
         * 创建魔法工厂
         */
        AbstractFactory modernFactory = new ModernFactory();
    }
}
