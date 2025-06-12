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
    public List<Product> getAllProducts(String categoryId) {
        List<Product> products = new ArrayList<>();
        String query = categoryId == null ? "SELECT * FROM products" : "SELECT * FROM products WHERE CategoryID = ?";

        try (Connection conn = DataManager.getConnection();
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

    public void createProduct(String productName, Integer categoryId, String quantityPerUnit, Double unitPrice,
                              Integer unitsInStock, Integer unitsOnOrder, Integer reorderLevel, boolean discontinued) {
        String query = "INSERT INTO products (ProductName, SupplierID, CategoryID, QuantityPerUnit, UnitPrice, " +
                "UnitsInStock, UnitsOnOrder, ReorderLevel, Discontinued) " +
                "VALUES (?, NULL, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DataManager.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(query)) {
            preparedStatement.setString(1, productName);
            preparedStatement.setObject(2, categoryId); // Allows null for CategoryID
            preparedStatement.setString(3, quantityPerUnit);
            preparedStatement.setObject(4, unitPrice); // Allows null for UnitPrice
            preparedStatement.setObject(5, unitsInStock); // Allows null for UnitsInStock
            preparedStatement.setObject(6, unitsOnOrder); // Allows null for UnitsOnOrder
            preparedStatement.setObject(7, reorderLevel); // Allows null for ReorderLevel
            preparedStatement.setBoolean(8, discontinued);

            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted == 0) {
                System.out.println("Failed to insert the product.");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateProduct(int productId, int stock) {
        String query = "UPDATE products SET UnitsInStock = ? WHERE ProductID = ?";

        try (Connection conn = DataManager.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(query)) {
            preparedStatement.setInt(1, stock);
            preparedStatement.setInt(2, productId);

            int rowsUpdated = preparedStatement.executeUpdate();
            if (rowsUpdated == 0) {
                System.out.println("No product found with ID: " + productId);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteProduct(int productId) {
        String query = "DELETE FROM products WHERE ProductID = ?";
        try (Connection conn = DataManager.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(query)) {
            preparedStatement.setInt(1, productId);

            int rowsDeleted = preparedStatement.executeUpdate();
            if (rowsDeleted == 0) {
                System.out.println("No product found with ID: " + productId);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Product> searchProductsByCategory(int categoryId) {
        List<Product> products = new ArrayList<>();
        String query = "SELECT * FROM products WHERE products.CategoryId = ?";

        try (Connection conn = DataManager.getConnection();
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
            System.out.println(e.getMessage());
        }

        return products;
    }


    public List<Customer> getAllCustomers() {
        List<Customer> customers = new ArrayList<>();
        String query = "SELECT * FROM customers";

        try (Connection conn = DataManager.getConnection();
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

    public List<Category> getAllCategories() {
        List<Category> categories = new ArrayList<>();
        String query = "SELECT * FROM categories";

        try (Connection conn = DataManager.getConnection();
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


}
