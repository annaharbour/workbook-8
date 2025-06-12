package pluralsight.ui;

import pluralsight.dao.NorthwindDao;
import pluralsight.models.Product;

import java.util.List;
import java.util.Scanner;

public class ProductsScreen implements ScreenState {
    @Override
    public void display(NorthwindDao dao) {
        List<Product> products = dao.getAllProducts(null);
        System.out.printf("%-4s %-40s %7s " +
                        "%8s%n--------------------------------------------------------------",
                "Id", "Product", "Price", "Stock");
        products.forEach(System.out::println);
    }


    @Override
    public ScreenState handleInput(Scanner scanner, NorthwindDao dao) {
        System.out.println("""
                What would you like to do?
                \t1) Delete a product
                \t2) Update a product
                \t3) Return to Home Screen
                Select an option:""");
        String input = scanner.nextLine();

        return switch (input) {
            case "1" -> new DeleteProductScreen();
            case "2" -> new UpdateProductScreen();
            case "3" -> new HomeScreen();
            default -> {
                System.out.println("Invalid input. Try again.");
                yield this;
            }
        };
    }
}
