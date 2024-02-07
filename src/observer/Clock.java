package observer;

public class Clock implements Observer {
    
    private ClockTimer timer;

    public Clock(ClockTimer ct){
        timer = ct;
        timer.attach(this);
    }

    public void update(Subject sub){
        if (sub == timer){
            tick();
        }
    }

    private void tick(){
        System.out.println(timer.getHour() + ":" + timer.getMinute() + ":" + timer.getSecond());
    }
}
