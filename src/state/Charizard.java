package state;

public class Charizard implements PokemonState {
    
    private int xp;

    // Constructor
    public Charizard() {
        System.out.println("Charizard appeared!");
    }

    // Perform action
    @Override
    public void performAction(Actions action) {
        
        // Perform action
        switch(action) {
            case ATTACK:
                System.out.println("Charizard used Fire Blast!");
                // Gain XP 30-40
                xp += 30 + (int)(Math.random() * 10);
                break;

            case DEFEND:
                System.out.println("Charizard used Protect!");
                // Gain XP 20-30
                xp += 20 + (int)(Math.random() * 10);
                break;

            case HEAL:
                System.out.println("Charizard used Hyper Potion!");
                // No XP gain
                break;
        }
    }

    @Override
    public int getXp() {
        return xp;
    }

    @Override
    public PokemonState.Evolution getEvolution() {
        return PokemonState.Evolution.Charizard;
    }
}
