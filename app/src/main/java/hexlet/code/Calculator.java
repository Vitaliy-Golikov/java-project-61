package hexlet.code;

import java.util.Scanner;
import java.util.Random;

public class Calculator {
    public static void startGame() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int score = 0;
        int finalScore = 3;
        String randomOperator = "+-*";
        User user = Cli.getCurrentUser();
        String userName = user.getName();
        int result = 0;

        System.out.println("What is the result of the expression?");

        while (score < finalScore) {
            int randomNumberOne = random.nextInt(1, 11);
            int randomNumberTwo = random.nextInt(1, 11);
            int randomNumChar = random.nextInt(0, randomOperator.length());
            char randomChar = randomOperator.charAt(randomNumChar);

            System.out.println("Question: " + " " + randomNumberOne + " " + randomChar + " " + randomNumberTwo);
            System.out.print("Your answer: ");
            int answer = scanner.nextInt();

            switch (randomChar) {
                case '+':
                    result = randomNumberOne + randomNumberTwo;
                    break;
                case '-':
                    result = randomNumberOne - randomNumberTwo;
                    break;
                case '*':
                    result = randomNumberOne * randomNumberTwo;
                    break;
                default: break;
            }

            boolean isCorrect = answer == result;

            if (isCorrect)  {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("'" + answer + "' is wrong answer ;(. Correct answer was '" + result + "'.");
                System.out.println("Let's try again, " + userName + "!");
                return;
            }
        }

        System.out.println("Congratulations, " + userName + "!");

    }
}
