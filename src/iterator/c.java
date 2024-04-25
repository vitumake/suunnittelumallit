package iterator;

import java.util.ArrayList;
import java.util.List;

public class c {
    public static void main(String[] args) {
        
        List<String> arr = new ArrayList<String>();
        
        // Populate list
        for (int i = 0; i < 10; i++) {
            arr.add("Value " + i);
        }

        // Changes to array during iteration

        // New thread
        Thread t1 = new Thread(new ArrayIterator(arr));

        // Start thread
        t1.start();

        // Change array
        arr.add("Value 10");
        arr.remove(3);
    }
}
