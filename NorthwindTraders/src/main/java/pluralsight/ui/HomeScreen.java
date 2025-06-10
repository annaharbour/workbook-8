package pluralsight.ui;

import pluralsight.dao.NorthwindDao;

import java.util.Scanner;

public class HomeScreen implements ScreenState {
    @Override
    public void display(NorthwindDao dao) {
        System.out.println("""
                What would you like to do?
                \t1) Display all products
                \t2) Display all customers
                \t3) \
                Exit
                Select an option:""");
    }

    @Override
    public ScreenState handleInput(Scanner scanner) {
        String input = scanner.nextLine();
        return switch (input) {
            case "1" -> new ProductsScreen();
            case "2" -> new CustomersScreen();
            case "3" -> null;
            default -> {
                System.out.println("Invalid input. Try again");
                yield this;
            }
        };
    }
}
