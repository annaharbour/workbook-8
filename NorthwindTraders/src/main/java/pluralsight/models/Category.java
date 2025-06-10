package pluralsight.models;

public class Category {
    private int categoryId;
    private String categoryName;

    public Category(int categoryId, String categoryName) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return String.format("%-20d %s\n---------------------------------------------",
                categoryId, categoryName);
    }
}
