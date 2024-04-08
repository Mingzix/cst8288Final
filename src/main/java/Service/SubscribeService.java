package Service;

import food.Subscribe;
import dao.SubscribeDao;

/**
 * Service layer class for managing subscription operations.
 * This class acts as an intermediary between the application's controller layer and the data access layer,
 * providing a higher level of abstraction for operations on subscriptions.
 * 
 * @author Shuting Wang
 */
public class SubscribeService {
    private SubscribeDao subscribeDao;

    /**
     * Constructs a new SubscribeService, initializing its underlying data access object.
     */
    public SubscribeService() {
        this.subscribeDao = new SubscribeDao();
    }

    /**
     * Adds a new subscription record to the database.
     * 
     * @param subscribe The Subscribe object containing the subscription details to be added.
     * @return The number of database rows affected by the operation. Typically, this will be 1 if the operation was successful.
     */
    public int addSubscribe(Subscribe subscribe) {
        return subscribeDao.addSubscribe(subscribe);
    }

    /**
     * Deletes all subscription records associated with a specific food item ID.
     * 
     * @param fid The ID of the food item for which subscriptions should be deleted.
     * @return The number of database rows affected by the operation.
     */
    public int deleteSubscribesByFid(int fid) {
        return subscribeDao.deleteSubscribesByFid(fid);
    }

    /**
     * Removes a specific subscription record from the database.
     * 
     * @param subscribe The Subscribe object containing the details of the subscription to be removed.
     * @return The number of database rows affected by the operation. Typically, this will be 1 if the operation was successful.
     */
    public int removeSubscribe(Subscribe subscribe) {
        return subscribeDao.removeSubscribe(subscribe);
    }
}
