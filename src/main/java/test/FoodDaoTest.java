package test;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dao.FoodDao;
import food.Food;
import food.FoodVo;
import utils.JDBCUtils;

/**
 * The FoodDaoTest class contains test cases for the methods in the FoodDao class.
 */
class FoodDaoTest {

    private FoodDao foodDao;
    private Food food;
    
    private Connection connection ;
    
    /**
     * Sets up the test environment before each test method runs.
     * 
     * @throws Exception if an error occurs during setup
     */
    @BeforeEach
    public void setUp() throws Exception {

        foodDao = new FoodDao();
        connection = JDBCUtils.getConnection();
       
        
    }
    /**
     * Tests the getFoodById method of the FoodDao class.
     * 
     * @throws Exception if an error occurs during the test
     */

    @Test
    public void testGetFoodById() throws Exception {

    	FoodVo result =  foodDao.getFoodById(1);
    	
    	assertNotNull(result);
    	

    }
    
    /**
     * Tests the getFoodList method of the FoodDao class.
     * 
     * @throws Exception if an error occurs during the test
     */
    
    @Test
    public void testGetFoodList() throws Exception {

    	List<FoodVo> result =  foodDao.getFoodList("consumer", 0, "1");
    	
    	assertNotNull(result);
    	

    }
    
   

}
