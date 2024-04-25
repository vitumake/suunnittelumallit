package facade;

import java.util.HashMap;

public class HardDrive {

    HashMap<Long, byte[]> data = new HashMap<Long, byte[]>();

    public HardDrive() {
        // Populate data
        for (long i = 0; i < 10; i++) {
            data.put(i, ("Data from sector " + i).getBytes());
        }
    }

    public String read(long lba, int size) {
        byte[] bytes = data.get(lba);
        if (bytes != null) {
            return new String(bytes);
        }
        return null;
    }
}
