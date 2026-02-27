package hexlet.code.game;

import hexlet.code.engine.GameEngine;
import java.util.Random;

public final class PrimeGame implements Game {

    private static final int MAX_NUMBER = 101;
    private static final int MIN_NUMBER = 1;

    private Random random = new Random();

    public static void startGame() {
        PrimeGame game = new PrimeGame();
        GameEngine.playGame(game);
    }

    @Override
    public String getRules() {
        return "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    }

    @Override
    public String[] generateQuestion() {
        int number = random.nextInt(MIN_NUMBER, MAX_NUMBER);
        String question = String.valueOf(number);
        String answer = isPrime(number) ? "yes" : "no";
        return new String[]{question, answer};
    }

    public static boolean isPrime(int a) {
        if (a <= 1) {
            return false;
        }

        int count = 0;
        for (int i = 1; i <= a; i++) {
            if (a % i == 0) {
                count++;
            }
        }
        return count == 2;
    }
}