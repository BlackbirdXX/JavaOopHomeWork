package HomeWork01;

import java.util.Random;

public class warrior extends startUnit{
    int endurance;
    int skill;
    
    public  warrior() {
        Random rand = new Random();
        this.endurance = rand.nextInt(40,50);
        this.skill = rand.nextInt(3,10);
    }

    public String printInfo() {
        return String.format("Воин %s \nЗдоровье : %d  Выносливость : %d  Мастерство : %d ",
        this.name, this.hp, this.endurance, this.skill);
    }

    public void GetDamageWar(int damage) {
        Random mod = new Random();
        if (this.hp > 0) {
            int reflection = mod.nextInt(this.skill);
            System.out.println(String.format("Воин получил %d урона.\nБлагодаря мастерству увернулся от %d.\n",damage, reflection));
            this.hp -= (damage - reflection);
        }
    }

    public void useEndurance() {
        if (this.endurance > 0) {
            this.endurance -= 5;
        }
    }
}
