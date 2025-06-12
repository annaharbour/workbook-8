package pluralsight.ui;

import pluralsight.dao.NorthwindDao;

import java.util.Scanner;

public class DeleteProductScreen implements ScreenState {

    @Override
    public void display(NorthwindDao dao) {
        System.out.println("Enter the ID of the product you want to delete:");
    }

    @Override
    public ScreenState handleInput(Scanner scanner, NorthwindDao dao) {
        int productId = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Deleting product with ID: " + productId);
        dao.deleteProduct(productId);
        return new HomeScreen();
    }
}