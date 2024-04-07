package Service;

import food.Subscribe;
import dao.SubscribeDao;

public class SubscribeService {
    private SubscribeDao subscribeDao;  
  
    public SubscribeService() {
        this.subscribeDao = new SubscribeDao();
    }  
  
    public int addSubscribe(Subscribe subscribe) {
       return subscribeDao.addSubscribe(subscribe);
    }  
  
    public int deleteSubscribesByFid(int fid) {
       return subscribeDao.deleteSubscribesByFid(fid);
    }

    public int removeSubscribe(Subscribe subscribe) {
        return subscribeDao.removeSubscribe(subscribe);
    }
}