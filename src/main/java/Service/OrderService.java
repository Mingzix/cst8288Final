package Service;

import dao.FoodDao;
import dao.OrderDao;
import food.FoodVo;
import food.Orders;

public class OrderService {
    private OrderDao orderDao;
    private FoodDao foodDao;
  
    public OrderService() {
        this.orderDao = new OrderDao();
        this.foodDao = new FoodDao();
    }  
  
    public int addOrder(Orders orders) {
        int i = orderDao.addOrder(orders);
        if(i>0){
            FoodVo foodVo = foodDao.getFoodById(orders.getFid());
            if(foodVo.getInventory()>=orders.getNum()){
                foodVo.setInventory(foodVo.getInventory()-orders.getNum());
                int updateFood = foodDao.updateFood(foodVo);
                return updateFood;
            }
        }
        return 0;
    }  
  
}