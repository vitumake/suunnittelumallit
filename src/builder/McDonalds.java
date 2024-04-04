package builder;

public class McDonalds implements Builder {
    
    private BigMac burger = new BigMac();

    

    @Override
    public Burger getResult() {
        return burger;
    }



    @Override
    public void addPatty(String pattyType) {
        burger.addPatty(pattyType);
    }



    @Override
    public void addCheese(String cheeseType) {
        burger.addCheese(cheeseType);
    }



    @Override
    public void addSauce(String sauceType) {
        burger.addSauce(sauceType);
    }



    @Override
    public void addVeggies(String veggiesType) {
        burger.addVeggies(veggiesType);
    }
}
