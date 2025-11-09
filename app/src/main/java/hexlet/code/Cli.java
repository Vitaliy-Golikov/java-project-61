package hexlet.code;

import java.util.Scanner;

public class Cli {
    private String name;

    public static void greet() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        This.name = scanner.nextLine();
        System.out.println("Hello, " + name + "!");

        scanner.close();
    }

    public static String getName() {
        return This.name;
    }
}
