package template;

import java.util.HashMap;
import java.util.Scanner;
import java.io.IOException;
import java.util.Arrays;

public class Yahtzee extends Game {
    
    //private int playersCount;
    private HashMap<Integer, Integer> scores; // Player scores
    private HashMap<Integer, int[][]> boards; // Player rolls
    private boolean endOfGame;

    public void initializeGame() {
        // Initialize the game
        scores = new HashMap<Integer, Integer>();
        boards = new HashMap<Integer, int[][]>();
        endOfGame = false;

        // Create boards for each player
        for (int i = 0; i < playersCount; i++) {
            // Add player to scores
            scores.put(i, 0);

            // Generate board for player
            boards.put(i, new int[16][6]);
        }

        System.out.println("Game initialized");
    }
    
    public void makePlay(int player) {

        // Clear the screen
        clearScreen();

        // Check if game is over
        if (checkGameOver()) {
            endOfGame = true;
            return;
        }

        // Process a turn
        System.out.println("Player " + player+1 + " is playing");

        // Get the player's board
        int[][] board = boards.get(player);


        // Draw the game board
        updateBoard(player);

        // Create dice and keep arrays
        int[] dice = new int[5];
        int[] keep = new int[5]; // 0 = roll, 1 = keep

        // Scanner for input
        Scanner scanner = new Scanner(System.in);

        // Initial roll
        dice = rollDice(dice, keep);
        System.out.println("Initial roll: " + getDice(dice));

        // Ask player to roll or add to board
        for(int i=0; i<2; i++){
            System.out.println("Roll again? (y/n)");
            String input = scanner.nextLine();
            if (input.equals("n")){
                break;
            }
            System.out.println("Which dice to keep? (1-5) (separate with space)");
            input = scanner.nextLine();
            
            // Parse input
            String[] inputArr = input.split(" ");
            for (int j = 0; j < inputArr.length; j++){
                keep[Integer.parseInt(inputArr[j])-1] = 1;
            }

            dice = rollDice(dice, keep);
            System.out.println("Roll: " + getDice(dice));
        }

        // Ask player to add roll to board
        boolean valid = false;
        while (!valid) {
            System.out.println("Which row to add to? (1-15)");
            int row = scanner.nextInt();
            // Check if row is valid
            if (isBetween(row, 1, 15) && board[row][0] == 0){
                board = addRollToBoard(board, dice, row-1);
                valid = true;
            } else {
                System.out.println("Invalid row");
            }
        }
        

        // Update the player's board
        boards.put(player, board);

        // Update the player's score
        scores.put(player, board[7][0] + board[15][0]);

        // Draw the game board
        updateBoard(player);

        System.out.println("Press enter to continue...");
        
        // Wait for input
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private boolean checkGameOver() {
        // Check if game is over
        for (int i = 0; i < playersCount; i++) {
            if (boards.get(i)[15][0] == 0) {
                return false;
            }
        }
        return true;
    }

    private int[][] addRollToBoard(int[][] board, int[] dice, int row){
        // Add roll to board
        for(int i = 0; i < 5; i++){
            board[row][i] = dice[i];
        }

        if(isBetween(row, 0, 5)){
            // Upper board
            board[row][5] = sumDieVal(row+1, dice);

            // Add to total
            board[7][0] += board[row][5];

            // Check for bonus
            if (board[7][0] >= 63){
                board[6][0] = 35;
                board[7][0] += 35;
            }

        } else {
            // Lower board
            switch(row){
                case 8:
                    // 3 of a kind
                    if (isThreeOfAKind(dice)){
                        board[row][5] = Arrays.stream(dice).sum();
                    } else {
                        board[row][5] = 0;
                    }
                    break;
                case 9:
                    // 4 of a kind
                    if (isFourOfAKind(dice)){
                        board[row][5] = Arrays.stream(dice).sum();
                    } else {
                        board[row][5] = 0;
                    }
                    break;
                case 10:
                    // Full house
                    if (isFullHouse(dice)){
                        board[row][5] = 25;
                    } else {
                        board[row][5] = 0;
                    }
                    break;
                case 11:
                    // Small straight
                    if (isSmallStraight(dice)){
                        board[row][5] = 30;
                    } else {
                        board[row][5] = 0;
                    }
                    break;
                case 12:
                    // Large straight
                    if (isLargeStraight(dice)){
                        board[row][5] = 40;
                    } else {
                        board[row][5] = 0;
                    }
                    break;
                case 13:
                    // Yahtzee
                    if (isYahtzee(dice)){
                        board[row][5] = 50;
                    } else {
                        board[row][5] = 0;
                    }
                    break;
                case 14:
                    // Chance
                    board[row][5] = Arrays.stream(dice).sum();
                    break;
                default:
                    System.out.println("Invalid row");
                    break;
            }
        }
        return board;
    }

    private boolean isYahtzee(int[] dice) {
        Arrays.sort(dice);
        return Arrays.stream(dice).distinct().count() == 1;
    }

    // These two methods are stupid but does it really matter in this context?
    private boolean isLargeStraight(int[] dice) {
        Arrays.sort(dice);
        return Arrays.equals(dice, new int[]{1, 2, 3, 4, 5}) || Arrays.equals(dice, new int[]{2, 3, 4, 5, 6});
    }
    private boolean isSmallStraight(int[] dice) {
        Arrays.sort(dice);
        return Arrays.equals(dice, new int[]{1, 2, 3, 4}) || Arrays.equals(dice, new int[]{2, 3, 4, 5}) || Arrays.equals(dice, new int[]{3, 4, 5, 6});
    }

    private boolean isFullHouse(int[] dice) {
        Arrays.sort(dice);
        return Arrays.equals(dice, new int[]{dice[0], dice[0], dice[0], dice[4], dice[4]}) || Arrays.equals(dice, new int[]{dice[0], dice[0], dice[4], dice[4], dice[4]});
    }

    private boolean isFourOfAKind(int[] dice) {
        Arrays.sort(dice);
        return dice[0] == dice[3] || dice[1] == dice[4];
    }

    private boolean isThreeOfAKind(int[] dice) {
        Arrays.sort(dice);
        return dice[0] == dice[2] || dice[1] == dice[3] || dice[2] == dice[4];
    }

    private void updateBoard(int player){

        // Get the player's board
        int[][] board = boards.get(player);

        // Update the player's score
        scores.put(player, board[7][0] + board[15][0]);

        // Draw the game board
        clearScreen();
        System.out.println("Player " + player + " is playing");
        drawBoard(board);
    }

    private void drawBoard(int[][] board) {

        // Draw the game board
        // Very basic implementation. Thank god for copilot
        System.out.println("Upper board:");
        System.out.println("1: Aces | " + getDice(board[0]) + "Sum: " + board[0][5]);
        System.out.println("2: Twos | " + getDice(board[1]) + "Sum: " + board[1][5]);
        System.out.println("3: Threes | " + getDice(board[2]) + "Sum: " + board[2][5]);
        System.out.println("4: Fours | " + getDice(board[3]) + "Sum: " + board[3][5]);
        System.out.println("5: Fives | " + getDice(board[4]) + "Sum: " + board[4][5]);
        System.out.println("6: Sixes | " + getDice(board[5]) + "Sum: " + board[5][5]);
        System.out.println("7: Bonus:" + board[6][0]);
        System.out.println("Upper board total:" + board[7][0]);
        System.out.println("-----------------");
        System.out.println("Lower board:");
        System.out.println("9: 3 of a kind" + getDice(board[8]) + board[8][5]);
        System.out.println("10: 4 of a kind" + getDice(board[9]) + board[9][5]);
        System.out.println("11: Full House" + getDice(board[10]) + board[10][5]);
        System.out.println("12: Small Straight" + getDice(board[11]) + board[11][5]);
        System.out.println("13: Large Straight" + getDice(board[12]) + board[12][5]);
        System.out.println("14: Yahtzee" + getDice(board[13]) + board[13][5]);
        System.out.println("15: Chance" + getDice(board[14]) + board[14][5]);
        System.out.println("16: Lower board total:" + board[15][0]);
        System.out.println("-----------------");
        System.out.println("Total:" + (board[7][0] + board[15][0]));
    }

    private void clearScreen() {
        // Clear the screen
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }

    // Util methods
    private int sumDieVal(int face, int[] row){
        int sum = 0;
        for (int i = 0; i < row.length; i++){
            if (row[i] == face){
                sum += face;
            }
        }
        return sum;
    }

    private String getDice(int[] row){
        String dice = "";
        for (int i = 0; i < row.length; i++){
            dice += getDie(row[i]);
        }
        return dice;
    }

    private String getDie(int val){
        String die = "";
        switch(val){
            case 1:
                die = "|.|";
                break;
            case 2:
                die = "|:|";
                break;
            case 3:
                die = "|:.|";
                break;
            case 4:
                die = "|::|";
                break;
            case 5:
                die = "|:.:|";
                break;
            case 6:
                die = "|:::|";
                break;
            default:
                return "";
        }
        // Encode the die string
        return die;
    }

    private boolean isBetween(int val, int min, int max){
        return val >= min && val <= max;
    }

    private int[] rollDice(int[] dice, int[] keep){
        for (int i = 0; i < dice.length; i++){
            if (keep[i] == 0){
                dice[i] = (int)(Math.random() * 6) + 1;
            }
        }
        return dice;
    }

    public boolean endOfGame() {
        // Return true if game is over
        return endOfGame;
    }
    
    public void printWinner() {
        // Display the winner
        System.out.println("Game over");

        // Find the winner
        int winner = 0;
        int highScore = 0;
        for (int i = 0; i < playersCount; i++) {
            if (scores.get(i) > highScore) {
                winner = i;
                highScore = scores.get(i);
            }
        }

        // Display the winner
        System.out.println("Player " + winner + " wins with " + highScore + " points");
    }
}
