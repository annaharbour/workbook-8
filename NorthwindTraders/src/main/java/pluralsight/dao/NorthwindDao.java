package pluralsight.dao;

import pluralsight.models.Category;
import pluralsight.models.Customer;
import pluralsight.models.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NorthwindDao {
    public List<Product> getAllProducts(String categoryId) throws SQLException {
        List<Product> products = new ArrayList<>();
        String query = categoryId == null ? "SELECT * FROM products" : "SELECT * FROM products WHERE CategoryID = ?";

        try (Connection conn = NorthwindConfig.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(query)) {
            if (categoryId != null) {
                preparedStatement.setInt(1, Integer.parseInt(categoryId));
            }
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    int id = Integer.parseInt(resultSet.getString("ProductID"));
                    String name = resultSet.getString("ProductName");
                    double price = resultSet.getDouble("UnitPrice");
                    int stock = resultSet.getInt("UnitsInStock");

                    products.add(new Product(id, name, price, stock));
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return products;
    }

    public List<Customer> getAllCustomers() throws SQLException {
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
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return customers;
    }

    public List<Category> getAllCategories() throws SQLException {
        List<Category> categories = new ArrayList<>();
        String query = "SELECT * FROM categories";

        try (Connection conn = NorthwindConfig.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                int id = Integer.parseInt(resultSet.getString("CategoryID"));
                String categoryName = resultSet.getString("CategoryName");

                categories.add(new Category(id, categoryName));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return categories;
    }

    public List<Product> getCategoryProducts(int categoryId) throws SQLException {
        List<Product> products = new ArrayList<>();
        String query = "SELECT * FROM products WHERE products.CategoryId = ?";

        try (Connection conn = NorthwindConfig.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(query)) {
            preparedStatement.setInt(1, categoryId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    int id = Integer.parseInt(resultSet.getString("ProductID"));
                    String name = resultSet.getString("ProductName");
                    double price = resultSet.getDouble("UnitPrice");
                    int stock = resultSet.getInt("UnitsInStock");

                    products.add(new Product(id, name, price, stock));
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());        }

        return products;
    }

}
