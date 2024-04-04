package builder;

public class Director {

    public Burger construct(Hesburger burgerBuilder) {
        burgerBuilder.addPatty("Hevospihvi");
        burgerBuilder.addCheese("Cheddar");
        burgerBuilder.addSauce("Kurkkumajo");
        burgerBuilder.addSauce("Paprikamajo");
        burgerBuilder.addVeggies("Salaatti");
        burgerBuilder.addVeggies("Tomaatti");
        return burgerBuilder.getResult();
    }

    public Burger construct(McDonalds burgerBuilder) {
        burgerBuilder.addPatty("Naudanliha");
        burgerBuilder.addCheese("Cheddar");
        burgerBuilder.addSauce("Ketsuppi");
        burgerBuilder.addSauce("Majo");
        burgerBuilder.addVeggies("Salaatti");
        burgerBuilder.addVeggies("Sipluli");
        return burgerBuilder.getResult();
    }
}
