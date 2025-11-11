package hexlet.code;

import java.util.Scanner;


public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
        System.out.println("3 - Calc");
        System.out.println("4 - GCD");
        System.out.println("0 - Exit");
        System.out.print("Your choice: ");
        int number = scanner.nextInt();

        switch (number) {
            case 1:
                Cli.greet();
                break;
            case 2:
                GameEngine.playGame(new Even());
                break;
            case 3:
                GameEngine.playGame(new Calculator());
                break;
            case 4:
                GameEngine.playGame(new Gcd());
                break;
            case 5:
                GameEngine.playGame(new ProgressionGame());
                break;
        }

    }
}
