package pluralsight.ui;

import pluralsight.dao.NorthwindDao;
import pluralsight.models.Category;
import pluralsight.models.Product;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class CategoryScreen implements ScreenState {
    @Override
    public void display(NorthwindDao dao) {
        try {
            System.out.println("Choose from the following categories to display products: ");
            List<Category> categories = dao.getAllCategories();
            System.out.printf("\n%-20s %-20s\n===========================================\n",
                    "Id", "Company");
            categories.forEach(System.out::println);
        } catch (Exception e) {
            System.out.println("Error fetching products: " + e.getMessage());
        }
    }

    @Override
    public ScreenState handleInput(Scanner scanner) {
        String id = scanner.nextLine();
        NorthwindDao dao = new NorthwindDao();
        displayProductsByCategory(dao, id);
        return new HomeScreen();
    }

    public void displayProductsByCategory(NorthwindDao dao, String categoryId) {
        try {
            List<Product> products = dao.getCategoryProducts(Integer.parseInt(categoryId));
            System.out.printf("%-4s %-40s %7s %8s\n--------------------------------------------------------------\n",
                    "Id", "Product", "Price", "Stock");
            products.forEach(System.out::println);
        } catch (SQLException e) {
            System.out.println("Error fetching products: " + e.getMessage());
        }
    }
}
