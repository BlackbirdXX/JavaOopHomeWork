package HomeWork02;

import java.util.Random;

public class wizard extends startUnit implements Bar{
    int mana;
    int experience;
    int maxHp;
    int maxMana;

    public  wizard() {
        Random rand = new Random();
        this.mana = rand.nextInt(40,50);
        this.experience = rand.nextInt(3,10);
        this.maxMana = mana;
        this.maxHp = hp;
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

    public void UseMana() {
        if (this.mana > 0) {
            this.mana -= 6;
        }
    }
    public int WizCast(){
        if(this.hp < 22) {
            Flask();
            System.out.println(String.format(ANSI_GREEN + "Колдун %s выпил восстанавливающее зелье", name + ANSI_RESET));
            return 0;
        }
        else if (this.mana <= 0){
            Flask();
            System.out.println(String.format(ANSI_GREEN + "Колдун %s выпил восстанавливающее зелье", name + ANSI_RESET));
            return 0;

        }
        else if (this.mana > 1){
        int damage = GenerateDamage(10, 15);
        UseMana();
        System.out.println(String.format("Колдун %s наносит %d урона.\n", name, damage));
        return damage;
        }
        else {return 0;}
    }
    @Override
    public void Flask() {
        this.hp += 25;
        this.mana += 25;
        if (this.hp > this.maxHp){
            this.hp = this.maxHp;
        }
        if (this.mana > this.maxMana){
            this.mana = this.maxMana;
        }
    }
}
