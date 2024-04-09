package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import food.FoodType;
import utils.JDBCUtils;
/**
 * The FoodTypeDao class provides methods to interact with the database
 * regarding food types.
 * 
 * @author Mingzi Xu 
 * @version version 1.1
 */
public class FoodTypeDao  {
	/**
     * Retrieves all food types from the database.
     *
     * @return A list of FoodType objects representing all food types retrieved from the database.
     */
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
            // Close resources
            JDBCUtils.close(rs, stmt, conn);
        } catch (SQLException e) {
            // Handle exceptions appropriately, log error, etc.
        }
        return foodTypes;
    }
}

