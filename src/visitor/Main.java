package visitor;

public class Main {
    
    public static void main(String[] args) {
        
        // Create Pokemon
        Pokemon pokemon = new Pokemon();
        
        // Perform actions
        while(pokemon.getState() instanceof Charizard == false){
            pokemon.accept(new ActionDistributor());
        }
    }
}
