// Import packages

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

// Main class

public class Main {

    public static void main(String[] args) {

        // Scanner object
        Scanner input = new Scanner(System.in);

        // ArrayLists
        ArrayList<Product> products = new ArrayList<>();
        ArrayList<Order> orders = new ArrayList<>();
        ArrayList<User> customers = new ArrayList<>();

        // Total sales
        double totalSales = 0;

        // =====================================
        // LOAD PRODUCTS FROM FILE
        // =====================================

        try {

            File productFile =
                    new File("products.txt");

            // Check file exists
            if (productFile.exists()) {

                Scanner productReader =
                        new Scanner(productFile);

                // Read file
                while (productReader.hasNextLine()) {

                    String line =
                            productReader.nextLine();

                    // Split values
                    String[] data =
                            line.split(",");

                    // Convert values
                    int id =
                            Integer.parseInt(data[0]);

                    String name = data[1];

                    double price =
                            Double.parseDouble(data[2]);

                    int stock =
                            Integer.parseInt(data[3]);

                    // Create product object
                    Product p =
                            new Product(id,
                                    name,
                                    price,
                                    stock);

                    // Add product
                    products.add(p);
                }

                productReader.close();
            }
        }

        catch (Exception e) {

            System.out.println(
                    "Error loading products!");
        }

        // =====================================
        // LOAD CUSTOMERS FROM FILE
        // =====================================

        try {

            File customerFile =
                    new File("customers.txt");

            // Check file exists
            if (customerFile.exists()) {

                Scanner customerReader =
                        new Scanner(customerFile);

                // Read file
                while (customerReader.hasNextLine()) {

                    String line =
                            customerReader.nextLine();

                    // Split values
                    String[] data =
                            line.split(",");

                    // Convert values
                    int id =
                            Integer.parseInt(data[0]);

                    String name = data[1];

                    // Create customer object
                    User u =
                            new User(id, name);

                    // Add customer
                    customers.add(u);
                }

                customerReader.close();
            }
        }

        catch (Exception e) {

            System.out.println(
                    "Error loading customers!");
        }

        // =====================================
        // ADMIN LOGIN
        // =====================================

        Admin admin = new Admin();

        System.out.println(
                "===== ADMIN LOGIN =====");

        System.out.print(
                "Enter Username: ");

        String username =
                input.nextLine();

        System.out.print(
                "Enter Password: ");

        String password =
                input.nextLine();

        // Check login
        if (admin.login(username, password)) {

            System.out.println(
                    "Login Successful!");
        }

        else {

            System.out.println(
                    "Wrong Username or Password!");

            return;
        }

        // Menu choice
        int choice;

        // =====================================
        // MAIN MENU LOOP
        // =====================================

        do {

            System.out.println(
                    "\n===== CHILL THRILL SYSTEM =====");

            System.out.println(
                    "1. Create Customer Account");

            System.out.println(
                    "2. Add Product");

            System.out.println(
                    "3. View Products");

            System.out.println(
                    "4. Delete Product");

            System.out.println(
                    "5. Place Order");

            System.out.println(
                    "6. View Orders");

            System.out.println(
                    "7. View Customers");

            System.out.println(
                    "8. View Sales Report");

            System.out.println(
                    "9. Exit");

            System.out.print(
                    "Enter Choice: ");

            choice = input.nextInt();

            // =====================================
            // CREATE CUSTOMER
            // =====================================

            if (choice == 1) {

                System.out.print(
                        "Enter Customer ID: ");

                int id = input.nextInt();

                input.nextLine();

                System.out.print(
                        "Enter Customer Name: ");

                String name =
                        input.nextLine();

                // Create customer object
                User u =
                        new User(id, name);

                // Add customer
                customers.add(u);

                // SAVE CUSTOMER TO FILE

                try {

                    FileWriter customerWriter =
                            new FileWriter(
                                    "customers.txt",
                                    true);

                    customerWriter.write(
                            id + "," +
                                    name + "\n");

                    customerWriter.close();
                }

                catch (Exception e) {

                    System.out.println(
                            "Error saving customer!");
                }

                System.out.println(
                        "Customer Account Created!");
            }

            // =====================================
            // ADD PRODUCT
            // =====================================

            else if (choice == 2) {

                System.out.print(
                        "Enter Product ID: ");

                int id = input.nextInt();

                input.nextLine();

                System.out.print(
                        "Enter Product Name: ");

                String name =
                        input.nextLine();

                System.out.print(
                        "Enter Product Price: ");

                double price =
                        input.nextDouble();

                System.out.print(
                        "Enter Stock Quantity: ");

                int stock =
                        input.nextInt();

                // Create product object
                Product p =
                        new Product(id,
                                name,
                                price,
                                stock);

                // Add product
                products.add(p);

                // SAVE PRODUCT TO FILE

                try {

                    FileWriter writer =
                            new FileWriter(
                                    "products.txt",
                                    true);

                    writer.write(
                            id + "," +
                                    name + "," +
                                    price + "," +
                                    stock + "\n");

                    writer.close();
                }

                catch (Exception e) {

                    System.out.println(
                            "Error saving product!");
                }

                System.out.println(
                        "Product Added Successfully!");
            }

            // =====================================
            // VIEW PRODUCTS
            // =====================================

            else if (choice == 3) {

                System.out.println(
                        "\n===== PRODUCT LIST =====");

                for (Product p : products) {

                    p.displayProduct();

                    System.out.println(
                            "-------------------");
                }
            }

            // =====================================
            // DELETE PRODUCT
            // =====================================

            else if (choice == 4) {

                System.out.print(
                        "Enter Product ID to Delete: ");

                int deleteId =
                        input.nextInt();

                boolean found = false;

                for (Product p : products) {

                    if (p.getProductId() ==
                            deleteId) {

                        products.remove(p);

                        found = true;

                        System.out.println(
                                "Product Deleted!");

                        break;
                    }
                }

                if (!found) {

                    System.out.println(
                            "Product Not Found!");
                }
            }

            // =====================================
            // PLACE ORDER
            // =====================================

            else if (choice == 5) {

                System.out.print(
                        "Enter Order ID: ");

                int orderId =
                        input.nextInt();

                input.nextLine();

                System.out.print(
                        "Enter Customer Name: ");

                String customer =
                        input.nextLine();

                System.out.print(
                        "Enter Bill Amount: ");

                double bill =
                        input.nextDouble();

                System.out.print(
                        "Enter Paid Amount: ");

                double paid =
                        input.nextDouble();

                // Create order object
                Order o =
                        new Order(orderId,
                                customer,
                                bill,
                                paid);

                // Add order
                orders.add(o);

                // Add sales
                totalSales =
                        totalSales + bill;

                // Display bill
                System.out.println(
                        "\n===== FINAL BILL =====");

                o.displayOrder();
            }

            // =====================================
            // VIEW ORDERS
            // =====================================

            else if (choice == 6) {

                System.out.println(
                        "\n===== ORDER LIST =====");

                for (Order o : orders) {

                    o.displayOrder();

                    System.out.println(
                            "-------------------");
                }
            }

            // =====================================
            // VIEW CUSTOMERS
            // =====================================

            else if (choice == 7) {

                System.out.println(
                        "\n===== CUSTOMER LIST =====");

                for (User u : customers) {

                    u.displayUser();

                    System.out.println(
                            "-------------------");
                }
            }

            // =====================================
            // SALES REPORT
            // =====================================

            else if (choice == 8) {

                System.out.println(
                        "\n===== DAILY SALES REPORT =====");

                System.out.println(
                        "Total Orders: " +
                                orders.size());

                System.out.println(
                        "Total Customers: " +
                                customers.size());

                System.out.println(
                        "Total Sales: Rs." +
                                totalSales);
            }

        }

        while (choice != 9);

        // Exit message
        System.out.println("System Closed!");
    }
}