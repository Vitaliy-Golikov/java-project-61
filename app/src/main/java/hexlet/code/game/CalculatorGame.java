package hexlet.code.game;

import java.util.Random;

public final class CalculatorGame implements Game {

    private static final int MAX_NUMBER = 11;
    private static final int MIN_NUMBER = 1;

    private Random random = new Random();
    private String currentQuestion;
    private String currentAnswer;

    @Override
    public String getRules() {
        return "What is the result of the expression?";
    }

    @Override
    public String generateQuestion() {
        int randomNumberOne = random.nextInt(MIN_NUMBER, MAX_NUMBER);
        int randomNumberTwo = random.nextInt(MIN_NUMBER, MAX_NUMBER);
        String[] operations = {"+", "-", "*"};
        String operation = operations[random.nextInt(operations.length)];

        currentQuestion = randomNumberOne + " " + operation + " " + randomNumberTwo;

        switch (operation) {
            case "+":
                currentAnswer = String.valueOf(randomNumberOne + randomNumberTwo);
                break;
            case "-":
                currentAnswer = String.valueOf(randomNumberOne - randomNumberTwo);
                break;
            case "*":
                currentAnswer = String.valueOf(randomNumberOne * randomNumberTwo);
                break;
            default:
                currentAnswer = "0";
        }

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
}
