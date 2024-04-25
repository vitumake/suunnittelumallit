package iterator;

import java.util.ArrayList;
import java.util.Iterator;

public class test {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            int element = iterator.next();
            System.out.println("Element: " + element);
            if (element % 2 == 0) {
                iterator.remove(); // Poistetaan parilliset numerot
                System.out.println("Removed: " + element);
            }
        }

        System.out.println("List after removal:");
        for (Integer num : list) {
            System.out.println(num);
        }
    }
}
