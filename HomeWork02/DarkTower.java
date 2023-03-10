package HomeWork02;

import java.util.Random;

public class DarkTower implements Bar {
    String name;
    int hp;
    int maxHp;
    int shield;
    int maxShield;

    public DarkTower() {
        Random rand = new Random();
        this.hp = rand.nextInt(180, 220);
        this.shield = 50;
        this.maxHp = hp;
        this.maxShield = shield;
    }

    public String printInfo() {

        return String.format("Темная башня \nЗдоровье : %d Щит : %d \n",
                this.hp, this.shield);
    }

    public void GetDamageTower(int damage1, int damage2) {
        int damage = damage1 + damage2;
        Random mod = new Random();
        if (this.shield > 0) {
            int absorbing = mod.nextInt(damage);
            System.out.println(String.format("Темная башня получила %d урона.\nЩиты поглотили %d.\n", damage,
            absorbing));
            this.hp -= (damage - absorbing);
            this.shield -= absorbing;
        }
        else {
            this.hp -= damage;
            System.out.println(String.format("Темная башня получила %d урона.\n", damage));
        }
    }

    public int TowerAttack() {
        int damage = GenerateDamage(10, 20);
        return damage;
    }
    public int Change() {
        Random ch = new Random();
        int change = ch.nextInt(3);
        return change;
    }

    @Override
    public void Flask() {
       
    }

}