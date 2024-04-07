package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import food.FoodType;
import utils.JDBCUtils;

public class FoodTypeDao  {

    public List<FoodType> getAllFoodTypes() {
        List<FoodType> foodTypes = new ArrayList<>();
        String sql = "select * from food_type";
        try (Connection conn = JDBCUtils.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                FoodType foodType = new FoodType();
                foodType.setId(rs.getInt("id"));
                foodType.setName(rs.getString("name"));
                foodTypes.add(foodType);
            }
            JDBCUtils.close(rs, stmt, conn);
        } catch (SQLException e) {
            // Handle exceptions appropriately, log error, etc.
        }
        return foodTypes;
    }
}

