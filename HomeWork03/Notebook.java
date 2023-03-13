package HomeWork03;

import java.util.Random;

public class Notebook implements Comparable<Notebook> {
    int article;
    int cost;
    int ram;
    int ssd;

    public Notebook(int article) {
        Random rand = new Random();
        this.article = article;
        this.cost = rand.nextInt(10000, 20000);
        this.ram = rand.nextInt(4, 16);
        this.ssd = rand.nextInt(1, 5) * 500;
        ;
    }

    public void PrintInfo() {
        System.out.println(String.format("Ноутбук № %d : Стоимость %d, Оперативная память %d гб, Накопитель %d гб.",
                this.article, this.cost, this.ram, this.ssd));

    }

    @Override
    public int compareTo(Notebook o) {
        if (this.ssd > o.ssd)
            return -1;
        if (this.ssd < o.ssd)
            return 1;
        if ((this.ssd == o.ssd) & (this.cost > o.cost))
            return 1;
        if ((this.ssd == o.ssd) & (this.cost < o.cost))
            return -1;
        else
            return 0;
    }

}
