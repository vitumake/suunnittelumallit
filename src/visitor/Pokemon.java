package visitor;

public class Pokemon {
    
    private PokemonState state;

    // Constructor
    public Pokemon() {
        state = new Charmander();
    }

    // Change state
    private void changeState(PokemonState state) {
        this.state = state;
    }

    // Accept
    public void accept(ActionVisitor visitor) {
        state.doAction(this, visitor);

        // Check for state change
        if(state instanceof Charmander) {
            if(state.getXp() >= 50) {
                changeState(new Charmeleon());
                System.out.println("Charmeleon appeared!\n");
            }
        }
        else if(state instanceof Charmeleon) {
            if(state.getXp() >= 100) {
                changeState(new Charizard());
                System.out.println("Charizard appeared!\n");
            }
        }
    }

    // GetState
    public PokemonState getState() {
        return state;
    }
}