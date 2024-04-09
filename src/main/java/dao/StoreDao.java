package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import food.Store;
import utils.JDBCUtils;  
/**
 * The StoreDao class provides methods to interact with store entities in the database.
 * @author Tao Chen
 */
public class StoreDao {  
	/**
     * Retrieves a list of all stores from the database.
     *
     * @return A list of Store objects representing all stores.
     */
	public List<Store> getAllStores() {
    	
    	 
        List<Store> stores = new ArrayList<>();
        Connection conn = null;  
        PreparedStatement stmt = null;  
        ResultSet rs = null;  
  
        try {  
            // SQL query to retrieve all stores
            String sql = "SELECT * FROM store";
            conn = JDBCUtils.getConnection();// Get connection from JDBCUtils class
            stmt = conn.prepareStatement(sql);  
            rs = stmt.executeQuery();
            // Iterate through the result set and create Store objects
            while (rs.next()) {  
                int storeId = rs.getInt("store_id");  
                String storeName = rs.getString("store_name");  
                String city = rs.getString("city");  
                int uid = rs.getInt("uid");  
                  
                Store store = new Store(storeId, storeName, city, uid);  
                stores.add(store);  
            }
            JDBCUtils.close(rs, stmt, conn);
        } catch (SQLException e) {
            e.printStackTrace();  
        }
  
        return stores;  
    }  
    /**
     * Retrieves a store by its user ID from the database.
     *
     * @param uid The user ID associated with the store.
     * @return The Store object corresponding to the given user ID, or null if not found.
     */
	 public Store getByUid(int uid) {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            // SQL query to retrieve a store by user ID
            String sql = "SELECT * FROM store where uid=?";
            conn = JDBCUtils.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, uid);
            rs = stmt.executeQuery();

            // If a record is found, create and return a Store object
            if (rs.next()) {
                int storeId = rs.getInt("store_id");
                String storeName = rs.getString("store_name");
                String city = rs.getString("city");
                return new Store(storeId, storeName, city, uid);
            }
            JDBCUtils.close(rs, stmt, conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
	 /**
	     * Adds a new store to the database.
	     *
	     * @param store The Store object representing the store to be added.
	     * @return The result of the operation (1 if successful, 0 otherwise).
	     */
    public int addStore(Store store) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {

            String sql = "insert into store(store_name,city,uid) values(?,?,?)";
            conn = JDBCUtils.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, store.getStoreName());
            stmt.setString(2, store.getCity());
            stmt.setInt(3, store.getUid());
            int result = stmt.executeUpdate();// Execute the insert statement
            JDBCUtils.close( stmt, conn);
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;// Return 0 if the operation fails
    }
}
