package hexlet.code.game;

import hexlet.code.engine.GameEngine;

import java.util.Random;

public final class GcdGame implements Game {

    private static final int MAX_NUMBER = 101;
    private static final int MIN_NUMBER = 1;

    private Random random = new Random();
    private String currentQuestion;
    private String currentAnswer;

    public static void startGame() {
        GcdGame game = new GcdGame();
        GameEngine.playGame(game);
    }

    @Override
    public String getRules() {
        return "Find the greatest common divisor of given numbers.";
    }

    @Override
    public String generateQuestion() {
        int numberOne = random.nextInt(MIN_NUMBER, MAX_NUMBER);
        int numberTwo = random.nextInt(MIN_NUMBER, MAX_NUMBER);

        String originalNumberOne = String.valueOf(numberOne);
        String originalNumberTwo = String.valueOf(numberTwo);

        currentAnswer = gcd(numberOne, numberTwo);

        currentQuestion = originalNumberOne + " " + originalNumberTwo;

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

    public static String gcd(int a, int b) {
        int num1 = a;
        int num2 = b;

        while (num1 != num2) {
            if (num1 > num2) {
                num1 -= num2;
            } else {
                num2 -= num1;
            }
        }
        return String.valueOf(num1);
    }
}
