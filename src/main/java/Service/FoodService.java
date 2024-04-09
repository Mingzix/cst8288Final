package Service;

import food.Food;
import food.FoodVo;
import food.Store;
import food.Subscribe;
import food.User;
import dao.FoodDao;
import dao.SubscribeDao;
import dao.UserDao;
import dao.StoreDao;
import utils.MailUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/**
 * The FoodService class provides methods to handle food-related functionalities
 * such as retrieving food items, updating food information, and adding new food items.
 * @author Mingzi Xu
 * @version 1.1
 * @since March 28, 2024
 *
 */
public class FoodService {
    private FoodDao foodDao;
    private SubscribeDao subscribeDao;
    private UserDao userDao;
    private StoreDao storeDao;
    /**
     * Constructs a new FoodService object and initializes DAO instances.
     */
    public FoodService(){
        foodDao = new FoodDao();
        subscribeDao = new SubscribeDao();
        userDao = new UserDao();
        storeDao = new StoreDao();
    }
    /**
     * Retrieves a list of food items based on the user type, user ID, and store ID.
     *
     * @param userType The type of user (e.g., "customer", "admin").
     * @param uid      The user ID.
     * @param storeId  The ID of the store.
     * @return A list of FoodVo objects representing the retrieved food items.
     */
    public List<FoodVo> getFoodList(String userType, int uid, String storeId){
        return foodDao.getFoodList(userType,uid,storeId);
    }
    /**
     * Retrieves information about a specific food item by its ID.
     *
     * @param fid The ID of the food item.
     * @return A FoodVo object representing the retrieved food item.
     */
    public FoodVo getFoodById(int fid){
        return foodDao.getFoodById(fid);
    }
    /**
     * Updates information about a food item in the database.
     * If the food item is marked as expired, it sends an email notification to subscribers
     * and deletes their subscriptions.
     *
     * @param food The Food object containing the updated information.
     * @return The number of rows affected in the database after the update operation.
     */
    public int updateFood(Food food){
        FoodVo foodVo = foodDao.getFoodById(food.getFid());
        int result = foodDao.updateFood(food);
        FoodVo foodVo2 = foodDao.getFoodById(food.getFid());
        if(foodVo.getIsExpired().equals("no") && foodVo2.getIsExpired().equals("yes") && result>0){
            //send email
            //check subscriber
            List<Subscribe> subscribeList = subscribeDao.getSubscribesByFid(food.getFid());
            //get user information
            List<Integer> uids = new ArrayList();
            for(Subscribe subscribe:subscribeList){
                uids.add(subscribe.getUid());
            }
            List<User> userList = userDao.getByUids(uids);
            Set<String> set = new HashSet<>();
            for (User user : userList) {
                set.add(user.getEmail());
            }
            MailUtils.sendEmail(set,"Food subscription reminder","The food "+foodVo.getFname()+" you subscribed to has been set as expired, go buy now!");
            
            subscribeDao.deleteSubscribesByFid(food.getFid());
        }
        return result;
    }

    /**
     * Adds a new food item to the database.
     * Retrieves the store ID based on the user ID and sets it for the food item.
     *
     * @param food The Food object representing the new food item to be added.
     * @param uid  The ID of the user adding the food item.
     * @return The number of rows affected in the database after the insertion operation.
     */
	  public int addFood(Food food, int uid) {
        Store store =  storeDao.getByUid(uid);
        if(store!=null){
            food.setStoreId(store.getStoreId());
        }
        return foodDao.addFood(food);
    }
}
