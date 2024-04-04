package builder;

public class Main {
    public static void main(String[] args) {
        Hesburger hesburgerBuilder = new Hesburger();
        McDonalds mcDonaldsBuilder = new McDonalds();
        
        Director burgerDirector = new Director();
        
        Burger bigmac = burgerDirector.construct(mcDonaldsBuilder);
        Burger kerroshampurilainen = burgerDirector.construct(hesburgerBuilder);

        System.out.println(bigmac);
        System.out.println(kerroshampurilainen);
    }
}
