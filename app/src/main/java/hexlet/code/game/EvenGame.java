package hexlet.code.game;

import java.util.Random;

public class EvenGame implements Game {
    private Random random = new Random();
    private String currentQuestion;
    private String currentAnswer;

    @Override
    public String getRules() {
        return "Answer 'yes' if the number is even, otherwise answer 'no'.";
    }

    @Override
    public String generateQuestion() {
        int number = random.nextInt(1, 21);
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
