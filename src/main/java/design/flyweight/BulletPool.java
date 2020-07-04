package design.flyweight;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * 享元模式 （池化技术）
 */
class Bullet{
    public UUID uuid = UUID.randomUUID();
    Boolean livling =true;

    @Override
    public String toString() {
        return super.toString();
    }
}
public class BulletPool {
    List<Bullet> bullets = new ArrayList<Bullet>();
    {
        for(int i=0;i<5;i++){
            bullets.add(new Bullet());
        }
    }

    public Bullet getBullet(){
        for (int i=0;i<bullets.size();i++){
            Bullet bullet = bullets.get(i);
            if(!bullet.livling){
                return bullet;
            }
        }
        return  new Bullet();
    }

    public static void main(String[] args) {
        BulletPool bp = new BulletPool();
        for(int i=0;i<10;i++){
            Bullet b = bp.getBullet();
            System.out.println(b);
        }
    }

}
