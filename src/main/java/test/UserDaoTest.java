package test;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.Test;

import dao.UserDao;
import food.User;
/**
 * The UserDaoTest class contains test cases for the methods in the UserDao class.
 */
class UserDaoTest {

	UserDao userDao;
	
    /**
     * Tests the getUserByNameAndPassword method of the UserDao class.
     */
	@Test
	void testGetUserByNameAndPassword() {

		userDao = new UserDao();
		User result = userDao.getUserByNameAndPassword("consumer", "123");
		assertNotNull(result);
	}

}
