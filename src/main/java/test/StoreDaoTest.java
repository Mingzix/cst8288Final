package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import dao.StoreDao;
import food.Store;

class StoreDaoTest {

	StoreDao storeDao;
	
	@Test
	void testGetStoreList() {
		storeDao = new StoreDao();
		
		List<Store> result = storeDao.getAllStores();
		
		assertNotNull(result);
	}

}
