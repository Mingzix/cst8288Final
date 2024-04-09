package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import dao.StoreDao;
import food.Store;
/**
 * The StoreDaoTest class contains test cases for the methods in the StoreDao class.
 */
class StoreDaoTest {

	StoreDao storeDao;
	/**
     * Tests the getAllStores method of the StoreDao class.
     */
	@Test
	void testGetStoreList() {
		storeDao = new StoreDao();
		
		List<Store> result = storeDao.getAllStores();
		
		assertNotNull(result);
	}

}
