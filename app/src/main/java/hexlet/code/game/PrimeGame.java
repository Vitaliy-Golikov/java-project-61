package hexlet.code.game;

import hexlet.code.engine.GameEngine;
import java.util.Random;

public final class PrimeGame implements Game {

    private static final int MAX_NUMBER = 101;
    private static final int MIN_NUMBER = 1;

    private Random random = new Random();
    private String currentQuestion;
    private String currentAnswer;

    public static void startGame() {
        PrimeGame game = new PrimeGame();
        GameEngine.playGame(game);
    }

    @Override
    public String getRules() {
        return "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    }

    @Override
    public String generateQuestion() {
        int number = random.nextInt(MIN_NUMBER, MAX_NUMBER);
        currentAnswer = isPrime(number) ? "yes" : "no";
        currentQuestion = String.valueOf(number);
        return currentQuestion;
    }

    @Override
    public String getCorrectAnswer() {
        return currentAnswer;
    }

    @Override
    public boolean checkAnswer(String userAnswer) {
        return currentAnswer.equals(userAnswer);
    }

    public static boolean isPrime(int a) {
        if (a <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(a); i++) {
            if (a % i == 0) {
                return false;
            }
        }
        return true;
    }
}