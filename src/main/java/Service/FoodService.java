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

public class FoodService {
    private FoodDao foodDao;
    private SubscribeDao subscribeDao;
    private UserDao userDao;
    private StoreDao storeDao;
    public FoodService()
    {
        foodDao = new FoodDao();
        subscribeDao = new SubscribeDao();
        userDao = new UserDao();
        storeDao = new StoreDao();
    }

    public List<FoodVo> getFoodList(String userType, int uid, String storeId){
        return foodDao.getFoodList(userType,uid,storeId);
    }

    public FoodVo getFoodById(int fid){
        return foodDao.getFoodById(fid);
    }

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

	
	  public int addFood(Food food, int uid) {
        Store store =  storeDao.getByUid(uid);
        if(store!=null){
            food.setStoreId(store.getStoreId());
        }
        return foodDao.addFood(food);
    }
}
