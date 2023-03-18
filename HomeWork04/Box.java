package HomeWork04;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Box<T extends Fruit> implements Iterable<T> {
    List<T> content = new ArrayList<>();
    
    public void addFruit(T Fruit) {
        content.add(Fruit);
    }


    public int getWeightBox() {
        int totalWeight = 0;
        for (T t : content) {
            totalWeight += t.getWeight();
        }
        return totalWeight;
    }
    public void getItemWeight() {
        for (T t : content) {
            System.out.println(t.getWeight()); 
        }
    }

    public void moveTo(Box<? super T> target) {
        target.content.addAll(content);
        content.clear();
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int cursor = 0;

            @Override
            public boolean hasNext() {
                return cursor < content.size();
            }

            @Override
            public T next() {
                return content.get(cursor++);
            }
        };

    }

}
