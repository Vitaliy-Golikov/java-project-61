package hexlet.code;

import java.util.Scanner;

public class Cli {

    private static User currentUser = new User();

    public static void greet() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String name = scanner.nextLine();
        currentUser.setName(name);
        System.out.println("Hello, " + name + "!");
    }

    public static User getCurrentUser() {
        return currentUser;
    }
}