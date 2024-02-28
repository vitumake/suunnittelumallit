package template;

import java.util.HashMap;
import java.util.Scanner;

public class Yahtzee extends Game {

    private HashMap<Integer, YahtzeeBoard> boards = new HashMap<Integer, YahtzeeBoard>();
    private Scanner scanner = null;

    @Override
    void initializeGame() {
        
        // Initialize the game
        for (int i = 0; i < playersCount; i++) {
            boards.put(i, new YahtzeeBoard());
        }
    }

    @Override
    void makePlay(int player) {
        
        // Make a play
        YahtzeeBoard board = boards.get(player);
        YahtzeeDice dice = new YahtzeeDice();

        // Create a new scanner
        if (scanner == null) {
            scanner = new Scanner(System.in);
        }

        // Draw the board
        clearScreen();
        System.out.println("Player " + (player + 1) + "'s turn");
        board.drawBoard();

        // Roll the dice
        dice.rollDice();
        System.out.println("You rolled: " + dice);

        // Ask the player to reroll the dice
        for(int i = 0; i < 2; i++) {
            System.out.println("Do you want to reroll the dice? (y/n) (rerolls left: " + (2 - i)+ ")");
            String reroll = scanner.nextLine();
            if (reroll.equals("y")) {

                // Clear the screen
                clearScreen();

                System.out.println("Roll: " + dice);
                System.out.println("Which dice do you want to keep? (1-5) (separate with spaces)");
                String keep = scanner.nextLine();
                String[] keepArray = keep.split(" ");
                int[] keepInt = new int[]{0, 0, 0, 0, 0};
                for (int j = 0; j < keepArray.length; j++) {
                    keepInt[Integer.parseInt(keepArray[j]) - 1] = 1;
                }
                dice.setKeep(keepInt);
                dice.rollDice();
                System.out.println("You rolled: " + dice);
            } else {
                break;
            }
        }

        // Clear the screen
        clearScreen();

        // Draw the board
        board.drawBoard();
        System.out.println("Roll: " + dice);

        // Ask the player to add the dice to the board
        System.out.println("Which category do you want to add the dice to?");
        boolean added = false;
        while (added == false) {
            int category = scanner.nextInt();
            added = board.addToBoard(category, dice);
        }

        // Clear the scanner
        scanner.nextLine();

        // Draw the board
        clearScreen();
        board.drawBoard();

        // Print the grand total
        System.out.println("Grand Total: " + board.getGrandTotal());

        // Wait for the player to press enter
        System.out.println("Turn ended, press enter to continue...");
        scanner.nextLine();
    }

    @Override
    boolean endOfGame() {
        
        // Check if the game is over
        for (int i = 0; i < playersCount; i++) {
            if (boards.get(i).isFilled() == false) {
                return false;
            }
        }
        return true;
    }

    @Override
    void printWinner() {
        
        // Print the winner
        int winner = 0;
        int winnerScore = 0;
        for (int i = 0; i < playersCount; i++) {
            if (boards.get(i).getGrandTotal() > winnerScore) {
                winner = i;
                winnerScore = boards.get(i).getGrandTotal();
            }
        }
        clearScreen();
        System.out.println("Player " + (winner + 1) + " wins with a score of " + winnerScore);
    }
    
    private void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}