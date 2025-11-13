package hexlet.code.engine;

import java.util.Scanner;

public class Cli {

    public static void greet() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String name = scanner.nextLine();
        System.out.println("Hello, " + name + "!");

    }
}
