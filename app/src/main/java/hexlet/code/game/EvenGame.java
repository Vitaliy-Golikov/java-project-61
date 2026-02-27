package hexlet.code.game;

import hexlet.code.engine.GameEngine;
import java.util.Random;

public final class EvenGame implements Game {

    private static final int MAX_NUMBER = 21;
    private static final int MIN_NUMBER = 1;

    private Random random = new Random();

    public static void startGame() {
        EvenGame game = new EvenGame();
        GameEngine.playGame(game);
    }

    @Override
    public String getRules() {
        return "Answer 'yes' if the number is even, otherwise answer 'no'.";
    }

    @Override
    public String[] generateQuestion() {
        int number = random.nextInt(MIN_NUMBER, MAX_NUMBER);
        String question = String.valueOf(number);
        String answer = isEven(number) ? "yes" : "no";
        return new String[]{question, answer};
    }

    private static boolean isEven(int number) {
        return number % 2 == 0;
    }
}