package state;

public class Charmander implements PokemonState {

    private int xp;

    // Constructor
    public Charmander() {
        System.out.println("Charmander appeared!");
    }

    // Perform action
    @Override
    public void performAction(Actions action) {
        
        // Perform action
        switch(action) {
            case ATTACK:
                System.out.println("Charmander used Blaze!\n");
                // Gain XP 10-20
                xp += 10 + (int)(Math.random() * 10);
                break;

            case DEFEND:
                System.out.println("Charmander used Protect!");
                // Gain XP 5-10
                xp += 5 + (int)(Math.random() * 5);
                break;

            case HEAL:
                System.out.println("Charmander used Potion!");
                // No XP gain
                break;
        }
    }

    @Override
    public int getXp() {
        return xp;
    }
}
