package hexlet.code;

import java.util.Scanner;
import java.util.Random;

public class Even {
    public static void startGame() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int score = 0;
        int finalScore = 3;
        User user = Cli.getCurrentUser();
        String userName = user.getName();

        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        while (score < finalScore) {
            int randomNumber = random.nextInt(1, 21);
            System.out.println("Question: " + randomNumber);
            System.out.print("Your answer: ");
            String preAnswer = scanner.nextLine();
            String answer = preAnswer.toLowerCase().trim();

            boolean numberIsEven = isEven(randomNumber);
            boolean isCorrect = (numberIsEven && answer.equals("yes")) || (!numberIsEven && answer.equals("no"));

            if (isCorrect) {
                System.out.println("Correct!");
                score++;
            } else {
                String correctAnswer = numberIsEven ? "yes" : "no";
                System.out.println("'" + answer + "' is wrong answer ;(. Correct answer was '" + correctAnswer + "'.");
                System.out.println("Let's try again, " + userName + "!");
                return;
            }
        }

        System.out.println("Congratulations, " + userName + "!");

    }

    public static boolean isEven(int num) {
        return num % 2 == 0;
    }
}
