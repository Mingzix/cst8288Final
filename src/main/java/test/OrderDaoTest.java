package test;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import dao.OrderDao;
import food.Orders;

class OrderDaoTest {
	OrderDao orderDao; 

	@Test
	void testGetAllOrders() {
		
		orderDao = new OrderDao();
		List<Orders> result = orderDao.getAllOrders();
		assertNotNull(result);
	}

}
