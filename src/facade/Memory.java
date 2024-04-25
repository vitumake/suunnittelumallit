package facade;

import java.util.HashMap;

public class Memory {
    
    HashMap<Long, String> data = new HashMap<Long, String>();

    public void load(long position, String data) {
        this.data.put(position, data);
        System.out.println("Loaded data at position " + position);
    }

    public String read(long position, int size) {
        String data = this.data.get(position);
        if (data != null) {
            return data;
        }
        return null;
    }
}
