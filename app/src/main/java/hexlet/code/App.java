package hexlet.code;

import hexlet.code.engine.Cli;
import hexlet.code.engine.GameEngine;
import hexlet.code.game.*;

import java.util.Scanner;


public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
        System.out.println("3 - Calc");
        System.out.println("4 - GCD");
        System.out.println("5 - Progression");
        System.out.println("6 - Prime");
        System.out.println("0 - Exit");
        System.out.print("Your choice: ");
        int number = scanner.nextInt();

        switch (number) {
            case 1:
                Cli.greet();
                break;
            case 2:
                GameEngine.playGame(new EvenGame());
                break;
            case 3:
                GameEngine.playGame(new CalculatorGame());
                break;
            case 4:
                GameEngine.playGame(new GcdGame());
                break;
            case 5:
                GameEngine.playGame(new ProgressionGame());
                break;
            case 6:
                GameEngine.playGame(new PrimeGame());
                break;
            case 0:
                break;
        }

    }
}
