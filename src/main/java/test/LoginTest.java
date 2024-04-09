package test;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import Service.UserService;
import food.User;
/**
 * The LoginTest class contains unit tests for user login functionality.
 * It tests the getUserByNameAndPassword method of the UserService class.
 */
class LoginTest {
	/**
     * Tests the getUserByNameAndPassword method of the UserService class.
     * Verifies that the correct user details are returned for valid credentials.
     */
	@Test
	void testGetUserByNameAndPassword() {
		// Instantiate UserService to perform credentials verification against DB
		UserService userService = new UserService();

		// Invoke getUserByNameAndPassword method to lookup the username and password
		// combination in the DB
		User user = userService.getUserByNameAndPassword("consumer", "123");

		assertEquals(user.getName(), "consumer");
		assertEquals(user.getEmail(), "consumer@163.com");
		assertEquals(user.getPassword(), "123");
		assertEquals(user.getUserType(), "consumer");
	}

}
