package pluralsight.dao;

import pluralsight.models.Customer;
import pluralsight.models.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NorthwindDao {
    public List<Product> getAllProducts() throws SQLException {
        List<Product> products = new ArrayList<>();
        String query = "SELECT * FROM products";

        try (Connection conn = NorthwindConfig.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                int id = Integer.parseInt(resultSet.getString("ProductID"));
                String name = resultSet.getString("ProductName");
                double price = resultSet.getDouble("UnitPrice");
                int stock = resultSet.getInt("UnitsInStock");

                products.add(new Product(id, name, price, stock));
            }
        }

        return products;
    }

    public List<Customer> getAllCustomers() throws SQLException{
        List<Customer> customers = new ArrayList<>();
        String query = "SELECT * FROM customers";

        try (Connection conn = NorthwindConfig.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                String companyName = resultSet.getString("CompanyName");
                String contactName = resultSet.getString("ContactName");
                String city = resultSet.getString("City");
                String country = resultSet.getString("Country");
                String phone = resultSet.getString("Phone");
                customers.add(new Customer(contactName, companyName, city, country, phone));
            }
        }

        return customers;
    }

}
