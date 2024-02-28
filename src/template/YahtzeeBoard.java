package template;

import java.util.HashMap;

public class YahtzeeBoard {
    
    private HashMap<Integer, YahtzeeDice> upperBoard;
    private HashMap<Integer, YahtzeeDice> lowerBoard;
    private int upperTotal;
    private int lowerTotal;
    private boolean bonus;
    private boolean boardFilled;

    public YahtzeeBoard() {
        upperBoard = new HashMap<Integer, YahtzeeDice>();
        lowerBoard = new HashMap<Integer, YahtzeeDice>();
        upperTotal = 0;
        lowerTotal = 0;
        bonus = false;
        boardFilled = false;
    }

    public void drawBoard() {

        String empty = " Empty ";

        // Draw the upper board
        System.out.println("Upper Board");
        System.out.println("1. Ones: " + (upperBoard.containsKey(1) ? upperBoard.get(1).getDieSum(1) : empty));
        System.out.println("2. Twos: " + (upperBoard.containsKey(2) ? upperBoard.get(2).getDieSum(2) : empty));
        System.out.println("3. Threes: " + (upperBoard.containsKey(3) ? upperBoard.get(3).getDieSum(3) : empty));
        System.out.println("4. Fours: " + (upperBoard.containsKey(4) ? upperBoard.get(4).getDieSum(4) : empty));
        System.out.println("5. Fives: " + (upperBoard.containsKey(5) ? upperBoard.get(5).getDieSum(5) : empty));
        System.out.println("6. Sixes: " + (upperBoard.containsKey(6) ? upperBoard.get(6).getDieSum(6) : empty));
        System.out.println("Upper Total: " + upperTotal);
        System.out.println("Bonus: " + (bonus ? "35" : "0"));
        System.out.println();

        // Draw the lower board
        System.out.println("Lower Board");
        System.out.println("7. Three of a Kind: " + (lowerBoard.containsKey(7) ? lowerBoard.get(7).getSums() : empty));
        System.out.println("8. Four of a Kind: " + (lowerBoard.containsKey(8) ? lowerBoard.get(8).getSums() : empty));
        System.out.println("9. Full House: " + (lowerBoard.containsKey(9) ? "25" : empty));
        System.out.println("10. Small Straight: " + (lowerBoard.containsKey(10) ? "30" : empty));
        System.out.println("11. Large Straight: " + (lowerBoard.containsKey(11) ? "40" : empty));
        System.out.println("12. Yahtzee: " + (lowerBoard.containsKey(12) ? "50" : ""));
        System.out.println("13. Chance: " + (lowerBoard.containsKey(13) ? lowerBoard.get(13).getSums() : empty));
        System.out.println("Lower Total: " + lowerTotal);
        System.out.println();

        // Draw the grand total
        System.out.println("Grand Total: " + getGrandTotal());
        System.out.println();
    }

    public Boolean addToBoard(int category, YahtzeeDice dice) {
        if (category < 7 && category > 0) {
            
            // Add to upper board

            //Check if the category is already taken
            if (upperBoard.containsKey(category)) {
                System.out.println("Category already taken");
                return false;
            }

            // Add to the board
            upperBoard.put(category, dice);

            // Calculate the total and add to the total
            int sum = 0;
            switch (category) {
                case 1:
                    sum = dice.getDieSum(1);
                    break;
                case 2:
                    sum = dice.getDieSum(2);
                    break;
                case 3:
                    sum = dice.getDieSum(3);
                    break;
                case 4:
                    sum = dice.getDieSum(4);
                    break;
                case 5:
                    sum = dice.getDieSum(5);
                    break;
                case 6:
                    sum = dice.getDieSum(6);
                    break;
            }
            upperTotal += sum;

            // Check if the bonus is achieved
            if (upperTotal >= 63 && !bonus) {
                upperTotal += 35;
                bonus = true;
            }

            // Check if the board is filled
            if (upperBoard.size() == 6) {
                boardFilled = true;
            }

            return true;

        } else if (category < 14 && category > 6) {
            
            // Add to lower board

            //Check if the category is already taken
            if (lowerBoard.containsKey(category)) {
                System.out.println("Category already taken");
                return false;
            }

            // Add to the board
            lowerBoard.put(category, dice);

            // Calculate the total and add to the total
            int sum = 0;
            switch (category) {
                case 7:
                    // Three of a kind
                    if(dice.isNOfAKind(3)) {
                        sum = dice.getSums();
                    }
                    break;
                case 8:
                    // Four of a kind
                    if(dice.isNOfAKind(4)) {
                        sum = dice.getSums();
                    }
                    break;
                case 9:
                    //Full house
                    if(dice.isFullHouse()) {
                        sum = 25;
                    }
                    break;
                case 10:
                    // Small straight
                    if(dice.isSmallStraight()) {
                        sum = 30;
                    }
                    break;
                case 11:
                    // Large straight
                    if(dice.isLargeStraight()) {
                        sum = 40;
                    }
                    break;
                case 12:
                    // Yahtzee
                    if(dice.isYahtzee()) {
                        sum = 50;
                    }
                    break;
                case 13:
                    // Chance
                    sum = dice.getSums();
                    break;
            }
            lowerTotal += sum;

            // Check if the board is filled
            if (lowerBoard.size() == 7) {
                boardFilled = true;
            }

            return true;
        } else {
            return false;
        }
    }

    public int getUpperTotal() {
         return upperTotal;
    }

    public int getLowerTotal() {
        return lowerTotal;
    }

    public int getGrandTotal() {
        return upperTotal + lowerTotal;
    }

    public boolean isFilled() {
        return boardFilled;
    }
}
