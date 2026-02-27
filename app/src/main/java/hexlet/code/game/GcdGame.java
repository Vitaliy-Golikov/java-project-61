package hexlet.code.game;

import hexlet.code.engine.GameEngine;
import java.util.Random;

public final class GcdGame implements Game {

    private static final int MAX_NUMBER = 101;
    private static final int MIN_NUMBER = 1;

    private Random random = new Random();

    public static void startGame() {
        GcdGame game = new GcdGame();
        GameEngine.playGame(game);
    }

    @Override
    public String getRules() {
        return "Find the greatest common divisor of given numbers.";
    }

    @Override
    public String[] generateQuestion() {
        int numberOne = random.nextInt(MIN_NUMBER, MAX_NUMBER);
        int numberTwo = random.nextInt(MIN_NUMBER, MAX_NUMBER);

        String question = numberOne + " " + numberTwo;
        String answer = String.valueOf(gcd(numberOne, numberTwo));

        return new String[]{question, answer};
    }

    public static int gcd(int a, int b) {
        int num1 = a;
        int num2 = b;

        while (num1 != num2) {
            if (num1 > num2) {
                num1 -= num2;
            } else {
                num2 -= num1;
            }
        }
        return num1;
    }
}