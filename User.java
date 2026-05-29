// User class

public class User {

    // Private variables
    private int customerId;
    private String customerName;

    // Constructor
    public User(int customerId, String customerName) {

        this.customerId = customerId;
        this.customerName = customerName;
    }

    // Getter for customer ID
    public int getCustomerId() {

        return customerId;
    }

    // Getter for customer name
    public String getCustomerName() {

        return customerName;
    }

    // Display customer details
    public void displayUser() {

        System.out.println("Customer ID: " + customerId);
        System.out.println("Customer Name: " + customerName);
    }
}