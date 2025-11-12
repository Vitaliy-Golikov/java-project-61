package hexlet.code;

import java.util.Random;

public class GcdGame implements Game {

    private Random random = new Random();
    private String currentQuestion;
    private String currentAnswer;

    @Override
    public String getRules() {
        return "Find the greatest common divisor of given numbers.";
    }

    @Override
    public String generateQuestion() {
        int numberOne = random.nextInt(1, 101);
        int numberTwo = random.nextInt(1, 101);

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

        return originalNumberOne + " " + originalNumberTwo;

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
