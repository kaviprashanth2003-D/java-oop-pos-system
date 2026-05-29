// Order class

public class Order {

    // Variables
    private int orderId;
    private String customerName;
    private double totalBill;
    private double paidAmount;
    private double balance;

    // Constructor
    public Order(int orderId,
                 String customerName,
                 double totalBill,
                 double paidAmount) {

        this.orderId = orderId;
        this.customerName = customerName;
        this.totalBill = totalBill;
        this.paidAmount = paidAmount;

        // Calculate balance
        this.balance = paidAmount - totalBill;
    }

    // Getter
    public double getTotalBill() {

        return totalBill;
    }

    // Display order details
    public void displayOrder() {

        System.out.println("Order ID: " + orderId);
        System.out.println("Customer Name: " + customerName);
        System.out.println("Total Bill: Rs." + totalBill);
        System.out.println("Paid Amount: Rs." + paidAmount);
        System.out.println("Balance: Rs." + balance);
    }
}