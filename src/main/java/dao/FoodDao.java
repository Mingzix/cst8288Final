package dao;

import food.Food;
import food.FoodVo;
import utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class FoodDao {

    public List<FoodVo> getFoodList(String userType,int uid, String storeId)
    {
        List<FoodVo> foods = new ArrayList();
        Connection connection;
        ResultSet rs = null;
        PreparedStatement pstmt;
        try {
            connection = JDBCUtils.getConnection();

            // Prepare the SQL query
            String sql = "";
            if("organization".equals(userType) ){
                sql = "SELECT * FROM food f,food_type ft where f.ftid=ft.id and f.is_donate=?";
            }else if("consumer".equals(userType)){
                sql = "SELECT *,IF(s.sid IS NOT NULL AND s.uid=?,1,0) is_subscribe FROM food f INNER JOIN food_type ft ON f.ftid=ft.id " +
                        "LEFT JOIN subscribe s ON f.fid=s.fid where f.is_donate=? and f.store_id=?";
            }else if("retailer".equals(userType)){
                sql="SELECT f.*,ft.name " +
                        "FROM food f,store s,food_type ft " +
                        "WHERE f.store_id=s.store_id AND ft.id=f.ftid AND s.uid=?";
            }
            pstmt = connection.prepareStatement(sql);
            if ("organization".equals(userType) ){
                pstmt.setInt(1,1);
            }else if ("consumer".equals(userType)){
                pstmt.setInt(1,uid);
                pstmt.setInt(2,0);
                pstmt.setString(3,storeId);
            }else if("retailer".equals(userType)){
                pstmt.setInt(1,uid);
            }

            rs = pstmt.executeQuery();

            // process the result set
            while (rs.next()) {
                FoodVo food = new FoodVo();
                food.setFid(rs.getInt("fid"));
                food.setFname(rs.getString("fname"));
                food.setExpiration(rs.getDate("expiration"));
                food.setPrice(rs.getBigDecimal("price"));
                food.setInventory(rs.getInt("inventory"));
                food.setDiscount(rs.getDouble("discount"));
                food.setFoodType(rs.getString("name"));
                food.setIsDonate(rs.getInt("is_donate"));
                if ("consumer".equals(userType)) {
                    food.setIsSubscribe(rs.getInt("is_subscribe"));
                }
                if(isWithinSevenDays(food.getExpiration())){
                    food.setIsExpired("yes");
                }else{
                    food.setIsExpired("no");
                }
                foods.add(food);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        JDBCUtils.close(rs, pstmt, connection);
        return foods;
    }

    public FoodVo getFoodById(int fid)
    {
        try {
            Connection connection = JDBCUtils.getConnection();
            ResultSet rs = null;
            // prepare the SQL query
            String sql = "SELECT * FROM food f,food_type ft where f.ftid=ft.id and f.fid=?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1,fid);
            // execute the query
            rs = pstmt.executeQuery();

            // proceed the result set
            if (rs.next()) {
                FoodVo food = new FoodVo();
                food.setFid(rs.getInt("fid"));
                food.setFname(rs.getString("fname"));
                food.setExpiration(rs.getDate("expiration"));
                food.setPrice(rs.getBigDecimal("price"));
                food.setInventory(rs.getInt("inventory"));
                food.setDiscount(rs.getDouble("discount"));
                food.setFoodType(rs.getString("name"));
                food.setIsDonate(rs.getInt("is_donate"));
                if(isWithinSevenDays(food.getExpiration())){
                    food.setIsExpired("yes");
                }else{
                    food.setIsExpired("no");
                }
                JDBCUtils.close(rs, pstmt, connection);
                return food;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    //updateFood to based on the fid to modify the inventory and expiration
    public int updateFood(Food food)
    {
        try {
            Connection connection = JDBCUtils.getConnection();
            String sql = "update food set is_donate=?,inventory=?,expiration=?,discount=? where fid=?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(5,food.getFid());
            pstmt.setDouble(4,food.getDiscount());
            pstmt.setDate(3,new java.sql.Date(food.getExpiration().getTime()));
            pstmt.setInt(2,food.getInventory());
            pstmt.setInt(1,food.getIsDonate());
            int result = pstmt.executeUpdate();
            JDBCUtils.close(pstmt, connection);
            return  result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isWithinSevenDays(Date expiration) {
        Date currentDate = new Date();

        Calendar currentCal = Calendar.getInstance();
        currentCal.setTime(currentDate);

        Calendar expirationCal = Calendar.getInstance();
        expirationCal.setTime(expiration);

        int daysDifference = Math.abs(expirationCal.get(Calendar.DAY_OF_YEAR) - currentCal.get(Calendar.DAY_OF_YEAR));

        return daysDifference <= 7;
    }

    public int addFood(Food food) {
           String sql =
                "INSERT INTO food(fid, fname, expiration, price, inventory, discount, ftid) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = JDBCUtils.getConnection();PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, food.getFid());
            pstmt.setString(2, food.getFname());
            pstmt.setDate(3, new java.sql.Date(food.getExpiration().getTime()));
            pstmt.setBigDecimal(4, food.getPrice());
            pstmt.setInt(5, food.getInventory());
            pstmt.setDouble(6, food.getDiscount());
            pstmt.setInt(7, food.getFtid());
            int executeUpdate = pstmt.executeUpdate();
            JDBCUtils.close(pstmt, connection);
            return executeUpdate;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }
}
