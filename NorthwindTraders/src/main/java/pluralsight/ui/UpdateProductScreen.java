package pluralsight.ui;

import pluralsight.dao.NorthwindDao;

import java.util.Scanner;

public class UpdateProductScreen implements ScreenState {

    @Override
    public void display(NorthwindDao dao) {
        System.out.println("Enter the ID of the product you want to update:");
    }

    @Override
    public ScreenState handleInput(Scanner scanner, NorthwindDao dao) {
        int productId = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter the new units in stock:");
        int newUnitsInStock = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Updating product with ID: " + productId + " to new units in stock: " + newUnitsInStock);
        dao.updateProduct(productId, newUnitsInStock);

        return new HomeScreen();
    }
}