package template;

public class YahtzeeDice {
    
    int[] dice;
    int[] keep;

    public YahtzeeDice() {
        dice = new int[5];
        keep = new int[]{0, 0, 0, 0, 0};
    }

    public YahtzeeDice(YahtzeeDice dice) {
        this.dice = dice.getDice();
    }

    public void rollDice() {
        for (int i = 0; i < 5; i++) {
            if (keep[i] == 0) {
                dice[i] = (int) (Math.random() * 6) + 1;
            }
        }
    }

    public void setKeep(int[] keep) {
        this.keep = keep;
    }

    public int[] getDice() {
        return dice;
    }

    public int getSums() {
        int sum = 0;
        for (int i = 0; i < 5; i++) {
            sum += dice[i];
        }
        return sum;
    }

    public int getDieSum(int die) {
        int sum = 0;
        for (int i = 0; i < 5; i++) {
            if (dice[i] == die) {
                sum += die;
            }
        }
        return sum;
    }

    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < 5; i++) {
            switch (Integer.toString(dice[i])) {
                case "1":
                    result += "[·] ";
                    break;
                case "2":
                    result += "[:] ";
                    break;
                case "3":
                    result += "[:·] ";
                    break;
                case "4":
                    result += "[::] ";
                    break;
                case "5":
                    result += "[:·:] ";
                    break;
                case "6":
                    result += "[:::] ";
                    break;
            }
        }
        return result;
    }

    // Dice checkers
    public boolean isNOfAKind(int n) {
        int[] counts = new int[6];
        for (int i = 0; i < 5; i++) {
            counts[dice[i] - 1]++;
        }
        for (int i = 0; i < 6; i++) {
            if (counts[i] >= n) {
                return true;
            }
        }
        return false;
    }

    public boolean isFullHouse() {
        int[] counts = new int[6];
        for (int i = 0; i < 5; i++) {
            counts[dice[i] - 1]++;
        }
        boolean two = false;
        boolean three = false;
        for (int i = 0; i < 6; i++) {
            if (counts[i] == 2) {
                two = true;
            }
            if (counts[i] == 3) {
                three = true;
            }
        }
        return two && three;
    }

    public boolean isSmallStraight() {
        int[] counts = new int[6];
        for (int i = 0; i < 5; i++) {
            counts[dice[i] - 1]++;
        }
        for (int i = 0; i < 3; i++) {
            if (counts[i] > 0 && counts[i + 1] > 0 && counts[i + 2] > 0 && counts[i + 3] > 0) {
                return true;
            }
        }
        return false;
    }

    public boolean isLargeStraight() {
        int[] counts = new int[6];
        for (int i = 0; i < 5; i++) {
            counts[dice[i] - 1]++;
        }
        for (int i = 0; i < 2; i++) {
            if (counts[i] > 0 && counts[i + 1] > 0 && counts[i + 2] > 0 && counts[i + 3] > 0 && counts[i + 4] > 0) {
                return true;
            }
        }
        return false;
    }

    public boolean isYahtzee() {
        int[] counts = new int[6];
        for (int i = 0; i < 5; i++) {
            counts[dice[i] - 1]++;
        }
        for (int i = 0; i < 6; i++) {
            if (counts[i] == 5) {
                return true;
            }
        }
        return false;
    }
}
