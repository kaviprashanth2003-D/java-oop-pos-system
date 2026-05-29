// Product class

public class Product {

    // Private variables
    private int productId;
    private String productName;
    private double price;
    private int stock;

    // Constructor
    public Product(int productId,
                   String productName,
                   double price,
                   int stock) {

        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.stock = stock;
    }

    // Getters
    public int getProductId() {

        return productId;
    }

    public String getProductName() {

        return productName;
    }

    public double getPrice() {

        return price;
    }

    public int getStock() {

        return stock;
    }

    // Reduce stock
    public void reduceStock(int qty) {

        stock = stock - qty;
    }

    // Display product
    public void displayProduct() {

        System.out.println(productId +
                " | " +
                productName +
                " | Rs." +
                price +
                " | Stock: " +
                stock);
    }
}