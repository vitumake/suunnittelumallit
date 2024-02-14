package state;

interface PokemonState {

    void performAction(Actions action);
    int getXp();
}
