package memento;

public class Main {
    
    public static void main(String[] args) {

        Arvuuttaja.setBounds(new int[] {1, 100});

        Thread[] threads = new Thread[3];

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new Arvailija("Player " + (i+1)));
            threads[i].start();
        }

    }
}
