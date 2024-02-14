package state;

public class Charmeleon implements PokemonState {
    
    private int xp;

    // Constructor
    public Charmeleon() {
        System.out.println("Charmeleon appeared!");
    }

    // Perform action
    @Override
    public void performAction(Actions action) {
        
        // Perform action
        switch(action) {
            case ATTACK:
                System.out.println("Charmeleon used Fire Spin!");
                // Gain XP 20-30
                xp += 20 + (int)(Math.random() * 10);
                break;

            case DEFEND:
                System.out.println("Charmeleon used Protect!");
                // Gain XP 10-20
                xp += 10 + (int)(Math.random() * 10);
                break;

            case HEAL:
                System.out.println("Charmeleon used Super Potion!");
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
        return PokemonState.Evolution.Charmeleon;
    }
}
