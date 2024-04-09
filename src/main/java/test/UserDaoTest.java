package test;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.Test;

import dao.UserDao;
import food.User;

class UserDaoTest {

	UserDao userDao;
	
	
	@Test
	void testGetUserByNameAndPassword() {

		userDao = new UserDao();
		User result = userDao.getUserByNameAndPassword("consumer", "123");
		assertNotNull(result);
	}

}
