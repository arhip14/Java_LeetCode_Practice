package GuessNumberHigherorLower;

public class Guess {
    public int guess(int num) {
        int pick = 6;
        if (num == pick) return 0;
        return num < pick ? 1 : -1;
    }
}