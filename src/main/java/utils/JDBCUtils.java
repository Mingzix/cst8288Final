package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * The {@code JDBCUtils} class provides utility methods for JDBC operations.
 * It includes methods for establishing database connections, closing resources,
 * and handling exceptions related to JDBC operations.
 * <p>
 * This class uses MySQL as the underlying database system.
 * </p>
 * 
 * @author Mingzi 
 * @version 1.2
 */
public class JDBCUtils {
    private static final String URL = "jdbc:mysql://localhost:3306/fwdb?useSSL=false&serverTimezone=UTC";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "algonquin";
    /**
     * Registers the MySQL JDBC driver.
     * This method is called once when the class is loaded.
     */
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //static Connection connection;
    /**
     * Establishes a connection to the database using the specified URL, username, and password.
     * 
     * @return a {@code Connection} object representing the database connection
     * @throws SQLException if a database access error occurs
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
    
    public static void close(ResultSet rs, PreparedStatement pstmt, Connection conn) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (pstmt != null) {
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    /**
     * Closes the specified PreparedStatement and Connection objects.
     * 
     * @param pstmt the {@code PreparedStatement} to close (can be {@code null})
     * @param conn the {@code Connection} to close (can be {@code null})
     */
    public static void close(PreparedStatement pstmt, Connection conn) {
        close(null, pstmt, conn);
    }
    /**
     * Closes the specified Connection object.
     * 
     * @param conn the {@code Connection} to close (can be {@code null})
     */
    public static void close( Connection conn) {
        close(null, null, conn);
    }
}
