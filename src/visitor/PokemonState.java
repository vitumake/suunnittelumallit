package visitor;

public class PokemonState {

    private int xp;

    public void doAction(Pokemon pokemon, ActionVisitor visitor) {
        visitor.visit(pokemon.getState()); 
    }
    void setXp(int xp) {
        this.xp = xp;
    }
    int getXp() {
        return xp;
    }
}
