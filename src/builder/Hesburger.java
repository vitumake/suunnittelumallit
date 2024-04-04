package builder;

public class Hesburger implements Builder {
    
    private Kerroshampurilainen burger = new Kerroshampurilainen();

    @Override
    public Burger getResult() {
        return burger;
    }

    @Override
    public void addPatty(String pattyType) {
        burger.addPatty(new Pihvi(pattyType));
    }

    @Override
    public void addCheese(String cheeseType) {
        burger.addCheese(new Juusto(cheeseType));
    }

    @Override
    public void addSauce(String sauceType) {
        burger.addSauce(new Kastike(sauceType));
    }

    @Override
    public void addVeggies(String veggiesType) {
        burger.addVeggies(new Vihannes(veggiesType));
    }
}
