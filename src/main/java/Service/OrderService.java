package Service;

import dao.FoodDao;
import dao.OrderDao;
import food.FoodVo;
import food.Orders;

/**
 * The OrderService class provides methods to interact with orders in the system.
 * @author Tao Chen
 */
public class OrderService {
    private OrderDao orderDao;
    private FoodDao foodDao;
    /**
     * Constructs a new OrderService object with default values.
     * Initializes OrderDao and FoodDao.
     */
    public OrderService() {
        this.orderDao = new OrderDao();
        this.foodDao = new FoodDao();
    }  
    /**
     * Adds a new order to the system.
     * Updates the inventory of the food item associated with the order.
     *
     * @param orders The order to be added.
     * @return The result of the operation (1 if successful, 0 otherwise).
     */
    public int addOrder(Orders orders) {
        // Add the order to the database

        int i = orderDao.addOrder(orders);
        if(i>0){// If order addition is successful
            // Retrieve the food item associated with the order

            FoodVo foodVo = foodDao.getFoodById(orders.getFid());
            if(foodVo.getInventory()>=orders.getNum()){
            	// Update the inventory of the food item
            	foodVo.setInventory(foodVo.getInventory()-orders.getNum());
                int updateFood = foodDao.updateFood(foodVo);
                return updateFood;// Return the result of updating the food item
            }
        }
        return 0;// Return 0 if order addition or inventory update fails
    }  
  
}