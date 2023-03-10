package HomeWork02;

import java.util.Random;

public class battle{

    public static int generateDamage(int min, int max) {
        int damage;
        Random d = new Random();
        damage = d.nextInt(min, max);
        return damage;
    }
    public static void wait(int ms) {
        try {
            Thread.sleep(ms);
        }
        catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    
        
    public static void main(String[] args) {
        System.out.print("\033[H\033[2J");
        System.out.println("Противники выходят на поле битвы, в сражении за власть....\n");
        wizard hero = new wizard();
        warrior hero2 = new warrior();
        DarkTower tower = new DarkTower();
        System.out.println(tower.printInfo());
        tower.StatusBar(tower.hp, tower.maxHp);
        tower.ShieldBar(tower.shield, tower.maxShield);
        System.out.println(hero.printInfo());
        hero.StatusBar(hero.hp, hero.maxHp);
        hero.ResursBar(hero.mana, hero.maxMana);
        System.out.println();
        System.out.println(hero2.printInfo());
        hero2.StatusBar(hero2.hp, hero2.maxHp);
        hero2.ResursBar(hero2.endurance, hero2.maxResurs);
        wait(3000);
        int count = 1;


        while ((hero.hp > 0 || hero2.hp > 0) & tower.hp > 0) {
            System.out.print("\033[H\033[2J");
            System.out.println(String.format("Раунд : %d \n", count));
            count++;
            tower.GetDamageTower(hero.WizCast(), hero2.WarAttack());
            tower.StatusBar(tower.hp, tower.maxHp);
            tower.ShieldBar(tower.shield, tower.maxShield);
            switch (tower.Change()) {
                case 0:
                    hero.GetDamageWiz(tower.TowerAttack());
                    break;
                case 1:
                    hero2.GetDamageWar(tower.TowerAttack());
                case 2:
                    hero.GetDamageWiz(tower.TowerAttack() / 2);
                    hero2.GetDamageWar(tower.TowerAttack() / 2);
                default:
                    break;
            }
            System.out.println(hero.printInfo());
            hero.StatusBar(hero.hp, hero.maxHp);
            hero.ResursBar(hero.mana, hero.maxMana);
            System.out.println(hero2.printInfo());
            hero2.StatusBar(hero2.hp, hero2.maxHp);
            hero2.ResursBar(hero2.endurance, hero2.maxResurs);
            wait(3000);
        }
        System.out.print("\033[H\033[2J");
        if ((hero.hp > 0 || hero2.hp > 0) & tower.hp < 1){
            System.out.println(String.format("Герои победили Темную башню!!!"));
        }
        else if (hero2.hp <= 0 & hero.hp <= 0 & tower.hp > 0){
            System.out.println(String.format("Темная башня устояла, герои пали в бою."));
        }
        else {
            System.out.println("В этой битве победителей нет..");
        }
    }
        
    }
