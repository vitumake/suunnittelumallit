package prototype;

import java.util.HashMap;
import java.util.Map;

public class Kello implements Cloneable {
    
    private Map<String, Viisari> hands = new HashMap<>();

    public Kello() {
        hands.put("hours", new Viisari(0));
        hands.put("minutes", new Viisari(0));
        hands.put("seconds", new Viisari(0));
    }

    public Viisari getHandValue(String key) {
        return hands.get(key);
    }

    public void setHandValue(String key, Viisari value) {
        hands.put(key, value);
    }

    @Override
    public Kello clone() {
        try {
            Kello kello = (Kello) super.clone();
            kello.hands = new HashMap<>(hands);
            return kello;
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}
