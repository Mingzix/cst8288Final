package test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utils.JDBCUtils;

import java.sql.Connection;
import java.sql.SQLException;

public class JDBCUtilsTest {

    @Test
    public void testGetConnection() {
        try {
            Connection connection = JDBCUtils.getConnection();
            Assertions.assertNotNull(connection, "Connection should not be null");
            Assertions.assertFalse(connection.isClosed(), "Connection should be open");
            connection.close();
        } catch (SQLException e) {
            Assertions.fail("Failed to get connection: " + e.getMessage());
        }
    }

    @Test
    public void testCloseResultSetPreparedStatementConnection() {
        // Create mocks for ResultSet, PreparedStatement, and Connection
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
        } catch (SQLException e) {
            Assertions.fail("Failed to get connection: " + e.getMessage());
        }
        // Simulate ResultSet, PreparedStatement, and Connection objects
        // Closing should not throw exceptions if they are null
        JDBCUtils.close(null, null, null);
        JDBCUtils.close(null, null, conn);
        try {
            conn.close();
        } catch (SQLException e) {
            Assertions.fail("Failed to close connection: " + e.getMessage());
        }
    }

    @Test
    public void testClosePreparedStatementConnection() {
        // Create mocks for PreparedStatement and Connection
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
        } catch (SQLException e) {
            Assertions.fail("Failed to get connection: " + e.getMessage());
        }
        // Simulate PreparedStatement and Connection objects
        // Closing should not throw exceptions if they are null
        JDBCUtils.close(null, conn);
        try {
            conn.close();
        } catch (SQLException e) {
            Assertions.fail("Failed to close connection: " + e.getMessage());
        }
    }

    @Test
    public void testCloseConnection() {
        // Create mock for Connection
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
        } catch (SQLException e) {
            Assertions.fail("Failed to get connection: " + e.getMessage());
        }
        // Simulate Connection object
        // Closing should not throw exceptions if it is null
        JDBCUtils.close(conn);
    }
}
