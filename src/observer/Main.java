package observer;

public class Main {
    public static void main (String args[]){
        
        ClockTimer timer = new ClockTimer();
        new Clock(timer);
        new Thread(timer).start();
    }
}
