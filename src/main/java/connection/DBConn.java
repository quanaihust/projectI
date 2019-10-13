package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn {
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/englishapp";
        String userName = "root";
        String password = "240799";
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection conn = DriverManager.getConnection(url,userName,password);
        return conn;
    }
}
