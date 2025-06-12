package pluralsight.ui;

import pluralsight.dao.NorthwindDao;
import pluralsight.models.Customer;

import java.util.List;
import java.util.Scanner;

public class CustomersScreen implements ScreenState {
    @Override
    public void display(NorthwindDao dao) {
            List<Customer> customers = dao.getAllCustomers();
            System.out.printf("\n%-40s%-40s%-40s%-40s%-40s", "Name", "Contact", "City", "Country", "Phone #");
            System.out.println(
                    "\n" +
                            "=========================================================================================================================================================================================================");
            customers.forEach(System.out::println);
    }


    @Override
    public ScreenState handleInput(Scanner scanner, NorthwindDao dao) {
        return new HomeScreen();
    }
}
