package hexlet.code.engine;

import hexlet.code.game.Game;
import java.util.Scanner;

public class GameEngine {

    private static final int SCORE = 0;
    private static final int FINAL_SCORER = 3;

    public static void playGame(Game game) {
        Scanner scanner = new Scanner(System.in);
        int score = 0;
        int finalScore = FINAL_SCORER;

        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String name = scanner.nextLine();
        System.out.println("Hello, " + name + "!");
        System.out.println(game.getRules());


        while (score < FINAL_SCORER) {
            String question = game.generateQuestion();
            System.out.println("Question: " + question);
            System.out.print("Your answer: ");

            String userAnswer = scanner.nextLine().trim().toLowerCase();

            if (game.checkAnswer(userAnswer)) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("'" + userAnswer + "' is wrong answer ;(. Correct answer was '"
                        + game.getCorrectAnswer() + "'.");
                System.out.println("Let's try again, " + name + "!");
                return;
            }
        }

        System.out.println("Congratulations, " + name + "!");

    }
}
