package adapter;

public class Main {
    
    public static void main(String[] args) {
        Rajapinta rajapinta = new Luokka();
        Rajapinta adaptoituRajapinta = new Adapter(new Adaptee());

        rajapinta.request();
        adaptoituRajapinta.request();
    }
}
