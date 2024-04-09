package test;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import Service.UserService;
import food.User;

class LoginTest {

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
