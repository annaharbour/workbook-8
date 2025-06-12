package pluralsight.ui;

import pluralsight.dao.NorthwindDao;

import java.util.Scanner;

public class CreateProductScreen implements ScreenState {

    @Override
    public void display(NorthwindDao dao) {
        System.out.println("Create a new product:");
    }

    @Override
    public ScreenState handleInput(Scanner scanner, NorthwindDao dao) {
        System.out.println("Enter product name:");
        String productName = scanner.nextLine();

        System.out.println("Enter category ID (or leave blank for null):");
        String categoryIdInput = scanner.nextLine();
        Integer categoryId = categoryIdInput.isEmpty() ? null : Integer.parseInt(categoryIdInput);

        System.out.println("Enter quantity per unit:");
        String quantityPerUnit = scanner.nextLine();

        System.out.println("Enter unit price (or leave blank for null):");
        String unitPriceInput = scanner.nextLine();
        Double unitPrice = unitPriceInput.isEmpty() ? null : Double.parseDouble(unitPriceInput);

        System.out.println("Enter units in stock (or leave blank for null):");
        String unitsInStockInput = scanner.nextLine();
        Integer unitsInStock = unitsInStockInput.isEmpty() ? null : Integer.parseInt(unitsInStockInput);

        System.out.println("Enter units on order (or leave blank for null):");
        String unitsOnOrderInput = scanner.nextLine();
        Integer unitsOnOrder = unitsOnOrderInput.isEmpty() ? null : Integer.parseInt(unitsOnOrderInput);

        System.out.println("Enter reorder level (or leave blank for null):");
        String reorderLevelInput = scanner.nextLine();
        Integer reorderLevel = reorderLevelInput.isEmpty() ? null : Integer.parseInt(reorderLevelInput);

        System.out.println("Is the product discontinued? (yes/no):");
        boolean discontinued = scanner.nextLine().equals("yes");

        dao.createProduct(productName, categoryId, quantityPerUnit, unitPrice, unitsInStock, unitsOnOrder, reorderLevel, discontinued);

        System.out.println("Product created successfully!");
        return new HomeScreen();
    }
}