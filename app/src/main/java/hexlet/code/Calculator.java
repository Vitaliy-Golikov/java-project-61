package hexlet.code;

import java.util.Random;

public class Calculator implements Game {
    private Random random = new Random();
    private String currentQuestion;
    private String currentAnswer;

    @Override
    public String getRules() {
        return "What is the result of the expression?";
    }

    @Override
    public String generateQuestion() {
        int randomNumberOne = random.nextInt(1, 11);
        int randomNumberTwo = random.nextInt(1, 11);
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