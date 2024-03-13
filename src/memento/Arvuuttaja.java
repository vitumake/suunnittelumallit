package memento;

import java.util.Random;

public class Arvuuttaja {
    
    private static int[] bounds = {1, 100};

    // Propably unnecessary but oh well
    private static Arvuuttaja instance = null;

    private Arvuuttaja() {
    }
    
    public static void setBounds(int[] bounds) {
        Arvuuttaja.bounds = bounds;
    }

    public Memento joinGame(Arvailija player) {

        System.out.println(player + " joined the game.");

        // Generate a random number between the bounds
        Random r = new Random();
        int min = bounds[0];
        int max = bounds[1];
        int value = r.nextInt((max - min) + 1) + min;

        System.out.println("The value for " + player + " is " + value);

        return new Memento(value);
    }
    
    public boolean makeGuess(Arvailija player, Memento value, Memento guess) {

        int feedback = value.getVal() - guess.getVal();
        player.recieveFeedback(feedback>0 ? 1 : feedback<0 ? -1 : 0);
        return feedback == 0;
    }

    public static Arvuuttaja getInstance() {
        if (instance == null) {
            instance = new Arvuuttaja();
        }
        return instance;
    }

    public int[] getBounds() {
        return bounds;
    }
}
