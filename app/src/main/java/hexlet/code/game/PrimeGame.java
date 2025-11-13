package hexlet.code.game;

import java.util.Random;

public class PrimeGame implements Game{

    private static final int MAX_NUMBER = 101;
    private static final int MIN_NUMBER = 1;

    private Random random = new Random();
    private String currentQuestion;
    private String currentAnswer;

    @Override
    public String getRules() {
        return "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    }

    @Override
    public String generateQuestion() {
        int number = random.nextInt(MIN_NUMBER, MAX_NUMBER);
        int count = 0;

        for (int i = 1; i <= number / 2; i++) {
            if (number % i == 0) {
                count++;
            }
        }

        currentAnswer = (count == 1 && number > 1) ? "yes" : "no";

        currentQuestion = String.valueOf(number);

        return currentQuestion;
    }

    @Override
    public  String getCorrectAnswer() {
        return currentAnswer;
    }

    @Override
    public boolean checkAnswer(String userAnswer) {
        return currentAnswer.equals(userAnswer);
    }

}
