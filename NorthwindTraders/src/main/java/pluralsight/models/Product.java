package pluralsight.models;

public class Product {
    private int productId;
    private String productName;
    private double price;
    private int unitsInStock;

    public Product(int productId, String productName, double price, int unitsInStock) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.unitsInStock = unitsInStock;
    }



    @Override
    public String toString() {
        return String.format("%-4d %-40s %7.2f %6d%n--------------------------------------------------------------",
                productId, productName, price, unitsInStock);
    }
}
