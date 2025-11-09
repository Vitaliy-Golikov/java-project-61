package hexlet.code;

import java.util.Scanner;
import java.util.Random;

public class Even {
    public static void startGame() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int score = 0;
        String userName = Cli.greet();
        int randomNumber = random.nextInt(1, 21);
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        for (int i = 0; i < score; i++) {
            System.out.println("Question: " + randomNumber);
            System.out.print("Your answer: ");
            String answer = scanner.nextLine();

            if (isEven(randomNumber) && answer.equals("yes") || !isEven(randomNumber) && answer.equals("no")) {
                System.out.println("Correct!");
                score++;
            } else if (isEven(randomNumber) && answer.equals("no") || !isEven(randomNumber) && answer.equals("yes")) {
                if (answer.equals("no")) {
                    System.out.println("'no' is wrong answer ;(. Correct answer was 'yes'.");
                    System.out.println("Let's try again, Bill!");
                } else {
                    System.out.println("'yes' is wrong answer ;(. Correct answer was 'no'.");
                    System.out.println("Let's try again, " + userName);
                }
            }


        }
    }

    public static boolean isEven(int num) {
        return num % 2 == 0;
    }
}
