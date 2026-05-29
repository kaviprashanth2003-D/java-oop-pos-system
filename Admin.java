// Admin class

public class Admin {

    // Username and password
    private String username = "admin";
    private String password = "1234";

    // Login method
    public boolean login(String user, String pass) {

        if (username.equals(user) &&
                password.equals(pass)) {

            return true;
        }

        else {

            return false;
        }
    }
}