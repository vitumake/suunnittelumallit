package state;

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

    // Perform action
    public void performAction() {
        
        // Get random action
        Actions[] actions = Actions.values();
        Actions action = actions[(int)(Math.random() * actions.length)];

        // Perform action
        state.performAction(action);
        
        // Print XP
        System.out.println(" XP: " + state.getXp());

        // Check XP
        if(state.getXp() >= 200) {
            if(state instanceof Charmander) {
                // Print evolution
                System.out.println("\nCharmander is evolving!");
                changeState(new Charmeleon());
            } else if(state instanceof Charmeleon) {
                // Print evolution
                System.out.println("\nCharmeleon is evolving!");
                changeState(new Charizard());
            }
        }
    }

    // GetState
    public PokemonState getState() {
        return state;
    }
}
