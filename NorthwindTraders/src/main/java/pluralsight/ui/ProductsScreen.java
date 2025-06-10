package pluralsight.ui;

import pluralsight.dao.NorthwindDao;
import pluralsight.models.Product;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class ProductsScreen implements ScreenState {
    @Override
    public void display(NorthwindDao dao) {
        try {
            List<Product> products = dao.getAllProducts();
            System.out.println(String.format("%-4s %-40s %7s " +
                            "%8s%n--------------------------------------------------------------",
                    "Id", "Product", "Price", "Stock"));
            products.forEach(System.out::println);
        } catch (SQLException e) {
            System.out.println("Error fetching products: " + e.getMessage());
        }
    }


    @Override
    public ScreenState handleInput(Scanner scanner) {
        return null;
    }
}
