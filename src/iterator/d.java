package iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class d {
    public static void main(String[] args) {
        
        // Test array iterator
        List<String> arr = new ArrayList<String>();
        
        // Populate list
        for (int i = 0; i < 10; i++) {
            arr.add("Value " + i);
        }
        Iterator<String> it = arr.iterator();
        
        // d) Iterator.remove during iteration
        // Poistaa parilliset

        // List
        System.out.println("List before removal:");
        System.out.println(arr);

        while(it.hasNext()) {
            String next = it.next();
            if(Integer.parseInt(next.substring(6)) % 2 == 0){
                it.remove();
            }
        }

        System.out.println("List after removal:");
        System.out.println(arr);
    }
}
