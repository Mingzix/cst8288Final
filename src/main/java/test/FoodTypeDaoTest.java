package test;

import static org.junit.Assert.assertNotNull;

import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.Test;

import dao.FoodTypeDao;
import food.FoodType;

/**
 * The FoodTypeDaoTest class contains test cases for the methods in the FoodTypeDao class.
 */
public class FoodTypeDaoTest {
	
	FoodTypeDao foodTypeDao;


    /**
     * Tests the getAllFoodTypes method of the FoodTypeDao class.
     * 
     * @throws SQLException if an SQL exception occurs
     */
	@Test
	public void testGetAllFoodTypes() throws SQLException {
		foodTypeDao = new FoodTypeDao();
		
		List<FoodType> result = foodTypeDao.getAllFoodTypes();
		
		assertNotNull(result);
	}

}
