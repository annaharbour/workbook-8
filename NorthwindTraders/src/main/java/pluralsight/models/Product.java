package pluralsight.models;

public class Product {
    private String productId;
    private String productName;
    private double price;
    private int inStock;

    public Product(String productId, String productName, double price, int inStock) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.inStock = inStock;
    }



    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ProductId: ").append(productId);
        sb.append("\nName:\t").append(productName);
        sb.append("\nPrice:\t").append(String.format("$%.2f", price));
        sb.append("\nStock:\t").append(inStock);
        sb.append("\n-------------------");
        return sb.toString();
    }
}
