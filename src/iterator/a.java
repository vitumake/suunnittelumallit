package iterator;

import java.util.ArrayList;
import java.util.List;

public class a {
    public static void main(String[] args) {
        
        // Test array iterator
        List<String> arr = new ArrayList<String>();

        // Populate list
        for (int i = 0; i < 10; i++) {
            arr.add("Value " + i);
        }

        // a)
        // Iterator with two threads at the same time

        // Create two threads
        Thread t1 = new Thread(new ArrayIterator(arr));
        Thread t2 = new Thread(new ArrayIterator(arr));

        // Start threads
        t1.start();
        t2.start();
    }
}
