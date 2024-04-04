package builder;

public class BigMac implements Burger {
    
    private String burger;
    private StringBuilder BurgerBuilder = new StringBuilder();

    public void addPatty(String patty) {
        BurgerBuilder.append(patty + "\n");
    }

    public void addCheese(String cheese) {
        BurgerBuilder.append(cheese + "\n");
    }

    public void addSauce(String sauce) {
        BurgerBuilder.append(sauce + "\n");
    }

    public void addVeggies(String veggies) {
        BurgerBuilder.append(veggies + "\n");
    }

    @Override
    public String toString() {
        burger = "Big Mac sisältää:\n" + BurgerBuilder.toString();
        return burger;
    }
}
