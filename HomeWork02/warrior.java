package HomeWork02;

import java.util.Random;

public class warrior extends startUnit implements Bar {
    int endurance;
    int skill;
    int maxHp;
    int maxResurs;
    
        
    public  warrior() {
        Random rand = new Random();
        this.endurance = rand.nextInt(40,50);
        this.skill = rand.nextInt(3,10);
        this.maxHp = hp;
        this.maxResurs = endurance;
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

    public void UseEndurance() {
        if (this.endurance > 0) {
            this.endurance -= 6;
        }
    }

    public int WarAttack(){
        if((this.hp < 22) || (this.endurance <= 0)) {
            Flask();
            System.out.println(String.format(ANSI_GREEN + "Воин %s выпил восстанавливающее зелье", name + ANSI_RESET));
            return 0;
        }
        else if (this.endurance > 1){
        int damage = GenerateDamage(10, 15);
        UseEndurance();
        System.out.println(String.format("Воин %s наносит %d урона.\n", name, damage));
        return damage;
        }
        else {return 0;}
    }

    @Override
    public void Flask() {
        this.hp += 25;
        this.endurance += 25;
        if (this.hp > this.maxHp){
            this.hp = this.maxHp;
        }
        if (this.endurance > this.maxResurs){
            this.endurance = this.maxResurs;
        }
    }

    }

    
   

