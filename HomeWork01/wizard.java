package HomeWork01;

import java.util.Random;

public class wizard extends startUnit{
    private int mana;
    private int experience;

    public  wizard() {
        Random rand = new Random();
        this.mana = rand.nextInt(40,50);
        this.experience = rand.nextInt(3,10);
    }

    public String printInfo() {
        return String.format("Колдун %s \nЗдоровье : %d  Запас маны : %d  Боевой опыт : %d ",
        this.name, this.hp, this.mana, this.experience);
    }

    public void GetDamageWiz(int damage) {
        Random mod = new Random();
        if (this.hp > 0) {
            int reflection = mod.nextInt(this.experience);
            System.out.println(String.format("Колдун получил %d урона.\nБлагодаря боевому опыту отразил %d.\n",damage, reflection));
            this.hp -= (damage - reflection);
        }
    }

    public void useMana() {
        if (this.mana > 0) {
            this.mana -= 5;
        }
    }
}
