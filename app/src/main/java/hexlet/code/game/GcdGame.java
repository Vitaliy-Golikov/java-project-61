package hexlet.code.game;

import java.util.Random;

public final class GcdGame implements Game {

    private static final int MAX_NUMBER = 101;
    private static final int MIN_NUMBER = 1;

    private Random random = new Random();
    private String currentQuestion;
    private String currentAnswer;

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

        while (numberOne != numberTwo) {

            if (numberOne > numberTwo) {
                numberOne -= numberTwo;
            } else {
                numberTwo -= numberOne;
            }
        }

        currentAnswer = String.valueOf(numberOne);

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
}
