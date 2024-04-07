package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import food.Store;
import utils.JDBCUtils;  
  
public class StoreDao {  
    public List<Store> getAllStores() {
        List<Store> stores = new ArrayList<>();
        Connection conn = null;  
        PreparedStatement stmt = null;  
        ResultSet rs = null;  
  
        try {  
            String sql = "SELECT * FROM store";
            conn = JDBCUtils.getConnection();
            stmt = conn.prepareStatement(sql);  
            rs = stmt.executeQuery();
  
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
}