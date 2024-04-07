package dao;

import food.Orders;
import utils.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;  
import java.util.List;  
  
public class OrderDao  {
    private static final String ADD_ORDER_SQL = "INSERT INTO orders(oid, uid, fid, money,num) VALUES (?, ?, ?, ?,?)";
    private static final String GET_ALL_ORDERS_SQL = "SELECT oid, uid, fid, money FROM orders";  
  
    private Connection getConnection() throws SQLException {
        return JDBCUtils.getConnection();
    }  
  
    public int addOrder(Orders orders) {
        try (Connection conn = getConnection();  
             PreparedStatement pstmt = conn.prepareStatement(ADD_ORDER_SQL)) {  
  
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
  
    public List<Orders> getAllOrders() {
        List<Orders> orders = new ArrayList<>();
        try (Connection conn = getConnection();  
             Statement stmt = conn.createStatement();  
             ResultSet rs = stmt.executeQuery(GET_ALL_ORDERS_SQL)) {  
  
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