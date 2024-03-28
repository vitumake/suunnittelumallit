package visitor;

public class ActionDistributor implements ActionVisitor {
    
    private int performAction(Actions action) {
        
        int xp=0;

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

        return xp;
    }

    @Override
    public void visit(PokemonState state) {
        
        // Get random action
        Actions action = Actions.values()[(int)(Math.random() * Actions.values().length)];

        // Perform action
        int xp = performAction(action);
        xp = state.getXp() + xp;
        state.setXp(xp);
    }
}
