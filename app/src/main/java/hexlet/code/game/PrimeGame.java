package hexlet.code.game;

import java.util.Random;

public class PrimeGame implements Game{
    private Random random = new Random();
    private String currentQuestion;
    private String currentAnswer;

    @Override
    public String getRules() {
        return "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    }

    @Override
    public String generateQuestion() {
        int number = random.nextInt(1,101);
        int count = 0;

        for (int i = 1; i <= number / 2; i++) {
            if (number % i == 0) {
                count++;
            }
        }

        currentAnswer = (count == 1 && number > 1) ? "yes" : "no";

        return String.valueOf(number);
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
