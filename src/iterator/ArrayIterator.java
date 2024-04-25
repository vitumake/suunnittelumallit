package iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayIterator implements Runnable {
    
    private Iterator<String> it;
    private List<String> arr2 = new ArrayList<String>();

    public ArrayIterator(List<String> arr) {
        this.it = arr.iterator();
    }

    public ArrayIterator(Iterator<String> it) {
        this.it = it;
    }

    @Override
    public void run() {
        while (it.hasNext()) {
            String next = it.next();
            System.out.println(String.format("%s: %s", Thread.currentThread().getName(), next));
            arr2.add(next);
        }
        printArr2();
    }

    private void printArr2() {
        System.out.println(arr2);
    }
}
