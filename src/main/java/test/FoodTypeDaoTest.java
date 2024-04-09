package test;

import static org.junit.Assert.assertNotNull;

import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.Test;

import dao.FoodTypeDao;
import food.FoodType;

public class FoodTypeDaoTest {
	
	FoodTypeDao foodTypeDao;


	
	@Test
	public void testGetAllFoodTypes() throws SQLException {
		foodTypeDao = new FoodTypeDao();
		
		List<FoodType> result = foodTypeDao.getAllFoodTypes();
		
		assertNotNull(result);
	}

}
