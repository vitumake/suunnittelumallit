package observer;

import java.time.LocalTime;

public class ClockTimer extends Subject implements Runnable {
    
    private LocalTime time;

    public int getHour() {
        return this.time.getHour();
    }

    public int getMinute() {
        return this.time.getMinute();
    }

    public int getSecond() {
        return this.time.getSecond();
    }

    @Override
    public void run() {
        while (true) {
            time = LocalTime.now();

            try {
                Thread.sleep(1000);
                alert();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
