package hexlet.code.game;

import hexlet.code.engine.GameEngine;

import java.util.Random;

public final class ProgressionGame implements Game {

    private static final int MIN_PROGRESS = 5;
    private static final int MAX_PROGRESS = 11;
    private static final int LENGTH_PROGRESS = 10;
    private static final int MIN_ADD_NUMBER = 1;
    private static final int MAX_ADD_NUMBER = 6;

    private Random random = new Random();
    private String currentQuestion;
    private String currentAnswer;

    public static void startGame() {
        ProgressionGame game = new ProgressionGame();
        GameEngine.playGame(game);
    }

    @Override
    public String getRules() {
        return "What number is missing in the progression?";
    }

    @Override
    public String generateQuestion() {
        int startProgression = random.nextInt(MIN_PROGRESS, MAX_PROGRESS);
        int addNumber = random.nextInt(MIN_ADD_NUMBER, MAX_ADD_NUMBER);
        int lengthProgression = LENGTH_PROGRESS;
        int delNumber = random.nextInt(lengthProgression);
        String[] progression = generateProgression(startProgression, addNumber, lengthProgression);
        currentQuestion = "";

        for (int i = 0; i < lengthProgression; i++) {

            if (i == delNumber) {
                currentQuestion += " " + "..";
                currentAnswer = String.valueOf(progression[i]);
            } else {
                currentQuestion += " " + String.valueOf(progression[i]);
            }

        }

        return currentQuestion.trim();

    }

    @Override
    public  String getCorrectAnswer() {
        return currentAnswer;
    }

    @Override
    public boolean checkAnswer(String userAnswer) {
        return currentAnswer.equals(userAnswer);
    }

    private static String[] generateProgression(int start, int step, int length) {
        String[] progression = new String[length];
        for (int i = 0; i < length; i++) {
            progression[i] = String.valueOf(start + i * step);
        }
        return progression;
    }

}
