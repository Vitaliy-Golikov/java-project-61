package hexlet.code.game;

import hexlet.code.engine.GameEngine;
import java.util.Random;

public final class EvenGame implements Game {

    private static final int MAX_NUMBER = 21;
    private static final int MIN_NUMBER = 1;

    private Random random = new Random();
    private String currentQuestion;
    private String currentAnswer;

    public static void startGame() {
        EvenGame game = new EvenGame();
        GameEngine.playGame(game);
    }

    @Override
    public String getRules() {
        return "Answer 'yes' if the number is even, otherwise answer 'no'.";
    }

    @Override
    public String generateQuestion() {
        int number = random.nextInt(MIN_NUMBER, MAX_NUMBER);
        currentQuestion = String.valueOf(number);
        currentAnswer = isEven(number) ? "yes" : "no";
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

    private static boolean isEven(int number) {
        return number % 2 == 0;
    }
}
