package hexlet.code.game;

import hexlet.code.engine.GameEngine;
import java.util.Random;

public final class ProgressionGame implements Game {

    private static final int MIN_START = 1;
    private static final int MAX_START = 20;
    private static final int MIN_STEP = 1;
    private static final int MAX_STEP = 10;
    private static final int LENGTH_PROGRESS = 10;

    private Random random = new Random();

    public static void startGame() {
        ProgressionGame game = new ProgressionGame();
        GameEngine.playGame(game);
    }

    @Override
    public String getRules() {
        return "What number is missing in the progression?";
    }

    @Override
    public String[] generateQuestion() {
        int start = random.nextInt(MIN_START, MAX_START);
        int step = random.nextInt(MIN_STEP, MAX_STEP);
        int hiddenIndex = random.nextInt(LENGTH_PROGRESS);

        String[] progression = generateProgression(start, step, LENGTH_PROGRESS);

        String answer = progression[hiddenIndex];
        progression[hiddenIndex] = "..";

        String question = String.join(" ", progression);

        return new String[]{question, answer};
    }

    private static String[] generateProgression(int start, int step, int length) {
        String[] progression = new String[length];
        for (int i = 0; i < length; i++) {
            progression[i] = String.valueOf(start + i * step);
        }
        return progression;
    }
}