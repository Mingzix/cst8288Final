package Service;

import food.Food;
import food.FoodVo;
import food.Subscribe;
import food.User;
import dao.FoodDao;
import dao.SubscribeDao;
import dao.UserDao;
import utils.MailUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FoodService {
    private FoodDao foodDao;
    private SubscribeDao subscribeDao;
    private UserDao userDao;
    public FoodService()
    {
        foodDao = new FoodDao();
        subscribeDao = new SubscribeDao();
        userDao = new UserDao();
    }

    public List<FoodVo> getFoodList(String userType,int uid){
        return foodDao.getFoodList(userType,uid);
    }

    public FoodVo getFoodById(int fid){
        return foodDao.getFoodById(fid);
    }

    public int updateFood(Food food){
        FoodVo foodVo = foodDao.getFoodById(food.getFid());
        int result = foodDao.updateFood(food);
        if(foodVo.getInventory()==0 && food.getInventory()>0 && result>0){
            
            List<Subscribe> subscribeList = subscribeDao.getSubscribesByFid(food.getFid());
            List<Integer> uids = new ArrayList();
            for(Subscribe subscribe:subscribeList){
                uids.add(subscribe.getUid());
            }
            List<User> userList = userDao.getByUids(uids);
            Set<String> set = new HashSet<>();
            for (User user : userList) {
                set.add(user.getEmail());
            }
           
            subscribeDao.deleteSubscribesByFid(food.getFid());
        }
        return result;
    }

    public int addFood(Food food) {
        return foodDao.addFood(food);
    }
}
