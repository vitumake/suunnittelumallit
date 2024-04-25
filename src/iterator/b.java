package iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class b {
    
    public static void main(String[] args) {        
        List<String> arr = new ArrayList<String>();
        
        // Populate list
        for (int i = 0; i < 10; i++) {
            arr.add("Value " + i);
        }
        Iterator<String> it = arr.iterator();
        
        // b) Multiple threads with same iterator

        // Create two threads
        Thread t1 = new Thread(new ArrayIterator(it));
        Thread t2 = new Thread(new ArrayIterator(it));

        // Start threads
        t1.start();
        t2.start();
        
    }
}
