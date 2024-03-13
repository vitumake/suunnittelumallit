package memento;

import java.util.Random;

public class Arvailija implements Runnable {
    
    private final String name;
    private Arvuuttaja arvuuttaja = Arvuuttaja.getInstance();
    private final int[] bounds = Arvuuttaja.getInstance().getBounds();
    private int lastGuess;
    
    public Arvailija(String name) {
        this.name = name;
    }
    
    public String toString() {
        return name;
    }
    
    public Memento joinGame() {
        return arvuuttaja.joinGame(this);
    }
    
    public Memento makeGuess() {

        // Make a new guess
        Random r = new Random();
        int min = this.bounds[0];
        int max = this.bounds[1];
        this.lastGuess = r.ints(min, (max+1))
            .findFirst()
            .getAsInt();

        System.out.println(this + " guessed " + lastGuess + ".\n"+
            this+" bounds:" + this.bounds[0] + " - " + this.bounds[1] + "\n");

        return new Memento(this.lastGuess);
    }

    public void recieveFeedback(int feedback) {
        if(feedback > 0) {
            this.bounds[0] = this.lastGuess + 1;
        } else if(feedback < 0) {
            this.bounds[1] = this.lastGuess - 1;
        }
    }

    public void run() {

        // Join the game
        Memento m = this.joinGame();

        while (!arvuuttaja.makeGuess(this, m, makeGuess())) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(this + " guessed " + lastGuess +". The number was " + lastGuess + ".");
    }
}
