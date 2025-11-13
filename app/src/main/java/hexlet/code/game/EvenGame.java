package hexlet.code.game;

import java.util.Random;

public final class EvenGame implements Game {

    private static final int MAX_NUMBER = 21;
    private static final int MIN_NUMBER = 1;

    private Random random = new Random();
    private String currentQuestion;
    private String currentAnswer;

    @Override
    public String getRules() {
        return "Answer 'yes' if the number is even, otherwise answer 'no'.";
    }

    @Override
    public String generateQuestion() {
        int number = random.nextInt(MIN_NUMBER, MAX_NUMBER);
        currentQuestion = String.valueOf(number);
        currentAnswer = (number % 2 == 0) ? "yes" : "no";
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
