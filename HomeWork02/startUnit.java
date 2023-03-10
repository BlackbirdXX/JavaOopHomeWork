package HomeWork02;

import java.util.Random;

public class startUnit{
    protected String name;
    protected int hp;
    

   public startUnit() {
    this.name = getName();
    this.hp = 50;
   }

   private String getName() {
    Random r = new Random();
        int val = r.nextInt(5, 9);
        switch (val) {
            case 0:
                name = "Азатот";
                break;
            case 1:
                name = "Дагон";
                break;
            case 2:
                name = "Бьякхи";
                break;
            case 3:
                name = "Голгорот";
                break;
            case 4:
                name = "Ктулху";
                break;
            case 5:
                name = "Ньярлатотеп";
                break;
            case 6:
                name = "Хастур";
                break;
            case 7:
                name = "Шаб-Ниггурат";
                break;
            case 8:
                name = "Йог-Сотхотх";
                break;
        }
        return String.format(name);
            }

        public String printName() {
            return String.format(name);
        }
    }
        

