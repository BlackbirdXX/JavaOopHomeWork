package HomeWork04;


public class Main {

    public static void main(String[] args) {
        System.out.print("\033[H\033[2J");
        Box<Apple> appleBox = new Box<>(); 
        Box<Orange> orangeBox = new Box<>(); 
        Box<GoldenApple> goldenAppleBox = new Box<>();
        // Box<String> stringBox = new Box(); //нельзя создать коробку не с фруктами
        appleBox.addFruit(new Apple(3)); // работает
        orangeBox.addFruit(new Orange(1)); // работает
        appleBox.addFruit(new GoldenApple(4)); // работает
        goldenAppleBox.addFruit(new GoldenApple(5));
        // goldenAppleBox.addFruit(new Orange(4)); //нельзя положить апельсины в коробку для яблок
        // orangeBox.addFruit(new Apple(4)); //нельзя положить яблоки в коробку для апельсинов
        System.out.println("Содержимое коробки с яблоками           " + appleBox.getWeightBox()); // 3+4
        System.out.println("Содержимое коробки с апельсинами        " + orangeBox.getWeightBox()); // 1
        System.out.println("Содержимое коробки с золотыми яблоками  " + goldenAppleBox.getWeightBox()); // 5
        goldenAppleBox.getItemWeight();
        goldenAppleBox.moveTo(appleBox);
        // orangeBox.moveTo(appleBox); // нельзя пересыпать апельсины к яблокам
        // appleBox.moveTo(goldenAppleBox); // нельзя пересыпать яблоки к золотым яблокам
        System.out.println("Содержимое коробки с яблоками           " + appleBox.getWeightBox()); // 3+4+5
        System.out.println("Содержимое коробки с апельсинами        " + orangeBox.getWeightBox()); // 1
        System.out.println("Содержимое коробки с золотыми яблоками  " + goldenAppleBox.getWeightBox()); // 0

        
        appleBox.getItemWeight();
        goldenAppleBox.getItemWeight();
    }
}