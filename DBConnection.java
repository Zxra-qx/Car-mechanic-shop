package mechanicshop.utility;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Handles connection to the MariaDB database.
 */
public class DBConnection {

    private static final String URL = "jdbc:mariadb://localhost:3306/mechanicshop";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            System.out.println("Database connection failed.");
            return null;
        }
    }
}
