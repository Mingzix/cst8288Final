package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import food.Orders;
import utils.JDBCUtils;  
/**
 * The OrderDao class provides methods to interact with order entities in the database.
 * @author Tao Chen
 */
public class OrderDao  {
    private static final String ADD_ORDER_SQL = "INSERT INTO orders(oid, uid, fid, money,num) VALUES (?, ?, ?, ?,?)";
    private static final String GET_ALL_ORDERS_SQL = "SELECT oid, uid, fid, money FROM orders";  
    /**
     * Retrieves a database connection from JDBCUtils.
     *
     * @return A Connection object representing the database connection.
     * @throws SQLException If a database access error occurs.
     */
    private Connection getConnection() throws SQLException {
        return JDBCUtils.getConnection();
    }  
    /**
     * Adds a new order to the database.
     *
     * @param orders The Orders object representing the order to be added.
     * @return The result of the operation (1 if successful, 0 otherwise).
     */
    public int addOrder(Orders orders) {
        try (Connection conn = getConnection();  
             PreparedStatement pstmt = conn.prepareStatement(ADD_ORDER_SQL)) {  
            
        	// Set parameters for the prepared statement
            pstmt.setInt(1, orders.getOid());
            pstmt.setInt(2, orders.getUid() ); 
            pstmt.setInt(3, orders.getFid() );
            pstmt.setBigDecimal(4, orders.getMoney());
            pstmt.setInt(5, orders.getNum());

            int executeUpdate = pstmt.executeUpdate();
            JDBCUtils.close(pstmt, conn);
            return executeUpdate;
        } catch (SQLException e) {  
            e.printStackTrace();  
        }
        return 0;
    }  
    /**
     * Retrieves a list of all orders from the database.
     *
     * @return A list of Orders objects representing all orders.
     */
    public List<Orders> getAllOrders() {
        List<Orders> orders = new ArrayList<>();
        try (Connection conn = getConnection();  
             Statement stmt = conn.createStatement();  
             ResultSet rs = stmt.executeQuery(GET_ALL_ORDERS_SQL)) {  
           
        	// Iterate through the result set and create Orders objects
            while (rs.next()) {  
                Orders order = new Orders();
                order.setOid(rs.getInt("oid"));  
                order.setUid(rs.getInt("uid"));  
                order.setFid(rs.getInt("fid"));  
                order.setMoney(rs.getBigDecimal("money"));  
                orders.add(order);  
            }  
        } catch (SQLException e) {  
            e.printStackTrace();  
        }  
        return orders;  
    }  
}