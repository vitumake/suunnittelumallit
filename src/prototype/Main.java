package prototype;

public class Main {
    
    public static void main(String[] args) {
        
        Kello kello = new Kello();
        kello.getHandValue("hours").setValue(10);
        kello.getHandValue("minutes").setValue(30);
        kello.getHandValue("seconds").setValue(45);
        
        Kello kello2 = kello.clone();
        
        System.out.println("Kello1:");
        System.out.println("Hours: " + kello.getHandValue("hours").getValue());
        System.out.println("Minutes: " + kello.getHandValue("minutes").getValue());
        System.out.println("Seconds: " + kello.getHandValue("seconds").getValue());
        
        System.out.println("Kello2:");
        System.out.println("Hours: " + kello2.getHandValue("hours").getValue());
        System.out.println("Minutes: " + kello2.getHandValue("minutes").getValue());
        System.out.println("Seconds: " + kello2.getHandValue("seconds").getValue());

        kello.getHandValue("hours").setValue(12);
        kello.getHandValue("minutes").setValue(0);
        kello.getHandValue("seconds").setValue(0);

        System.out.println("Kello1:");
        System.out.println("Hours: " + kello.getHandValue("hours").getValue());
        System.out.println("Minutes: " + kello.getHandValue("minutes").getValue());
        System.out.println("Seconds: " + kello.getHandValue("seconds").getValue());

        System.out.println("Kello2:");
        System.out.println("Hours: " + kello2.getHandValue("hours").getValue());
        System.out.println("Minutes: " + kello2.getHandValue("minutes").getValue());
        System.out.println("Seconds: " + kello2.getHandValue("seconds").getValue());

    }
}
