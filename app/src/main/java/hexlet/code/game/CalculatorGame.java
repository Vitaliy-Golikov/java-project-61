package hexlet.code.game;

import hexlet.code.engine.GameEngine;
import java.util.Random;

public final class CalculatorGame implements Game {

    private static final int MAX_NUMBER = 11;
    private static final int MIN_NUMBER = 1;

    private Random random = new Random();

    public static void startGame() {
        CalculatorGame game = new CalculatorGame();
        GameEngine.playGame(game);
    }

    @Override
    public String getRules() {
        return "What is the result of the expression?";
    }

    @Override
    public String[] generateQuestion() {
        int randomNumberOne = random.nextInt(MIN_NUMBER, MAX_NUMBER);
        int randomNumberTwo = random.nextInt(MIN_NUMBER, MAX_NUMBER);
        String[] operations = {"+", "-", "*"};
        String operation = operations[random.nextInt(operations.length)];

        String question = randomNumberOne + " " + operation + " " + randomNumberTwo;
        String answer = String.valueOf(calc(randomNumberOne, randomNumberTwo, operation));

        return new String[]{question, answer};
    }

    private static int calc(int a, int b, String operation) {
        return switch (operation) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            default -> throw new RuntimeException("Unknown operation: " + operation);
        };
    }
}