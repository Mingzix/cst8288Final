package test;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import dao.OrderDao;
import food.Orders;
/**
 * The OrderDaoTest class contains test cases for the methods in the OrderDao class.
 */
class OrderDaoTest {
	OrderDao orderDao; 

    /**
     * Tests the getAllOrders method of the OrderDao class.
     */
	@Test
	void testGetAllOrders() {
		
		orderDao = new OrderDao();
		List<Orders> result = orderDao.getAllOrders();
		assertNotNull(result);
	}

}
