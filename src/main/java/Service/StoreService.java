package Service;

import java.util.List;
import dao.StoreDao;
import food.Store;

public class StoreService {
    private StoreDao storeDao = new StoreDao();
  
    public List<Store> getAllStores() {
        return storeDao.getAllStores();  
    }  
}