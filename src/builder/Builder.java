package builder;

interface Builder {
    
    public void addPatty(String pattyType);
    public void addCheese(String cheeseType);
    public void addSauce(String sauceType);
    public void addVeggies(String veggiesType);
    public Burger getResult();
}
