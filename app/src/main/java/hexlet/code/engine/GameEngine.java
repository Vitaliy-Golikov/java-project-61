package hexlet.code.engine;

import hexlet.code.game.Game;
import hexlet.code.user.User;
import java.util.Scanner;

public class GameEngine {
    public static void playGame(Game game) {
        Scanner scanner = new Scanner(System.in);
        int score = 0;
        int finalScore = 3;

        Cli.greet();
        User user = Cli.getCurrentUser();
        String userName = user.getName();
        System.out.println(game.getRules());

        while (score < finalScore) {
            String question = game.generateQuestion();
            System.out.println("Question: " + question);
            System.out.print("Your answer: ");

            String userAnswer = scanner.nextLine().trim().toLowerCase();

            if (game.checkAnswer(userAnswer)) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("'" + userAnswer + "' is wrong answer ;(. Correct answer was '" + game.getCorrectAnswer() + "'.");
                System.out.println("Let's try again, " + userName + "!");
                return;
            }
        }

        System.out.println("Congratulations, " + userName + "!");

    }
}
