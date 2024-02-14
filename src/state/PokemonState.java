package state;

interface PokemonState {

    enum Evolution {
        Charizard, Charmeleon, Charmander
    }
    PokemonState.Evolution getEvolution();
    void performAction(Actions action);
    int getXp();
}
