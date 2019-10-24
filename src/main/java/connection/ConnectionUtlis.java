package connection;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionUtlis {
    public static Connection getConnection() throws SQLException {
        return DBConn.getConnection();
    }

    public static void closeQuietly(Connection conn) {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void rollbackQuietly(Connection conn) {
        try {
            conn.rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
