package hexlet.code;

import hexlet.code.engine.Cli;
import hexlet.code.engine.GameEngine;
import hexlet.code.game.EvenGame;
import hexlet.code.game.CalculatorGame;
import hexlet.code.game.GcdGame;
import hexlet.code.game.ProgressionGame;
import hexlet.code.game.PrimeGame;

import java.util.Scanner;


public class App {

    private static final int GREET = 1;
    private static final int EVEN_GAME = 2;
    private static final int CALC_GAME = 3;
    private static final int GCD_GAME = 4;
    private static final int PROGRESSION_GAME = 5;
    private static final int PRIME_GAME = 6;
    private static final int EXIT = 0;

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
            case GREET:
                Cli.greet();
                break;
            case EVEN_GAME:
                GameEngine.playGame(new EvenGame());
                break;
            case CALC_GAME:
                GameEngine.playGame(new CalculatorGame());
                break;
            case GCD_GAME:
                GameEngine.playGame(new GcdGame());
                break;
            case PROGRESSION_GAME:
                GameEngine.playGame(new ProgressionGame());
                break;
            case PRIME_GAME:
                GameEngine.playGame(new PrimeGame());
                break;
            case EXIT:
                break;
            default:
                System.out.println("Unknown user choice " + "'" + number + "'");
                break;
        }
    }
}
