package pluralsight.ui;

import javax.sql.DataSource;
import java.util.Scanner;

public class HomeScreen {
    public static void display() {
        System.out.println("""
                What would you like to do?
                \t1) Display all actors
                \t2) Search films
                \t3) Search actors by name
                \t0) Exit
                Select an option:""");
    }

    public static void run(Scanner scanner, DataSource dao) {
        String input;
        do {
            display();
            input = scanner.nextLine();
            switch (input) {
                case "0" -> input = "0";
                case "1" -> Search.displayActors(dao);
                case "2" -> Search.searchFilms(scanner, dao);
                case "3" -> Search.searchActors(scanner, dao);
                default -> {
                    System.out.println("Invalid input. Try again");
                }
            }
        } while (!"0".equals(input));
    }
}