package pluralsight.ui;

import pluralsight.dao.NorthwindDao;
import pluralsight.models.Customer;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class CustomersScreen implements ScreenState {
    @Override
    public void display(NorthwindDao dao) {
        try {
            List<Customer> customers = dao.getAllCustomers();
            System.out.printf("\n%-40s%-40s%-40s%-40s%-40s", "Name", "Contact", "City", "Country", "Phone #");
            System.out.println(
                    "\n" +
                            "=========================================================================================================================================================================================================");
            customers.forEach(System.out::println);
        } catch (SQLException e) {
            System.out.println("Error fetching customers: " + e.getMessage());
        }
    }


    @Override
    public ScreenState handleInput(Scanner scanner) {
        return new HomeScreen();
    }
}
