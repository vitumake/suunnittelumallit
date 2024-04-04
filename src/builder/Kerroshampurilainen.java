package builder;

import java.util.ArrayList;

public class Kerroshampurilainen implements Burger {
    
    ArrayList<Ingridient> ingredients = new ArrayList<Ingridient>();

    public void addPatty(Pihvi pihvi) {
        ingredients.add(pihvi);
    }

    public void addCheese(Juusto juusto) {
        ingredients.add(juusto);
    }

    public void addSauce(Kastike kastike) {
        ingredients.add(kastike);
    }

    public void addVeggies(Vihannes vihannes) {
        ingredients.add(vihannes);
    }

    @Override
    public String toString() {
        String burger = "Kerroshampurilainen sisältää:\n";
        for (Ingridient ingridient : ingredients) {
            burger += ingridient.getName() + "\n";
        }
        return burger;
    }
}
