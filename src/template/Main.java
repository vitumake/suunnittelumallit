package template;

import java.io.IOException;

public class Main {
    
    public static void main(String[] args) throws IOException {
        // Create a new game
        Yahtzee game = new Yahtzee();
        
        // Play the game
        game.playOneGame(2);
    }
}
