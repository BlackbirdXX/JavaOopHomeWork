package HomeWork01;

import java.util.Random;

public class battle {

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
        System.out.println(hero.printInfo());
        System.out.println();
        System.out.println(hero2.printInfo());
        wait(3000);

        while (hero.hp > 0 & hero2.hp > 0) {
            System.out.print("\033[H\033[2J");
            hero.GetDamageWiz(generateDamage(10, 15));
            hero.useMana();
            hero2.GetDamageWar(generateDamage(10, 15));
            hero2.useEndurance();
            System.out.println(hero.printInfo());
            System.out.println();
            System.out.println(hero2.printInfo());
            wait(3000);
        }
        System.out.print("\033[H\033[2J");
        if (hero.hp <= 0 & hero2.hp > 0){
            System.out.println(String.format("Властителем темного мира становится %s \n%s отправляется в небытие...", hero2.name, hero.name));
        }
        else if (hero2.hp <= 0 & hero.hp > 0){
            System.out.println(String.format("Властителем темного мира становится %s \n%s отправляется в небытие...", hero.name, hero2.name));
        }
        else {
            System.out.println("Оба противника пали в бою...");
        }
    }
        
    }
