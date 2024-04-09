package Service;

import java.util.List;
import dao.StoreDao;
import food.Store;
/**
 * The StoreService class provides methods to interact with store entities in the system.
 *  @author Tao Chen
 */
public class StoreService {
    private StoreDao storeDao = new StoreDao();
    /**
     * Retrieves a list of all stores in the system.
     *
     * @return A list of Store objects representing all stores.
     */
    public List<Store> getAllStores() {
        return storeDao.getAllStores();  
    }
    /**
     * Adds a new store to the system.
     *
     * @param store The store to be added.
     * @return The result of the operation (1 if successful, 0 otherwise).
     */
    public  int addStore(Store store) {
        return storeDao.addStore(store);
    }
}
