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


class FoodDaoTest {

    private FoodDao foodDao;
    private Food food;
    
    private Connection connection ;
    @BeforeEach
    public void setUp() throws Exception {

        foodDao = new FoodDao();
        connection = JDBCUtils.getConnection();
       
        
    }


    @Test
    public void testGetFoodById() throws Exception {

    	FoodVo result =  foodDao.getFoodById(1);
    	
    	assertNotNull(result);
    	

    }
    
    @Test
    public void testGetFoodList() throws Exception {

    	List<FoodVo> result =  foodDao.getFoodList("consumer", 0, "1");
    	
    	assertNotNull(result);
    	

    }
    
   

}
