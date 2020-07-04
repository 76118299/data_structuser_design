package design.abstractfactory;

public abstract class AbstractFactory {
    /**
     * 生产食物
     * @return
     */
    abstract Food createFood();

    /**
     * 生产交通工具
     * @return
     */
    abstract Vehicle createVechicle();

    /**
     * 生产武器
     * @return
     */
    abstract Weapon createWeapon();
}
