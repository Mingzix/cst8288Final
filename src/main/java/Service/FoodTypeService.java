package Service;

import java.util.List;

import dao.FoodTypeDao;
import food.FoodType;

public class FoodTypeService {
    private FoodTypeDao foodTypeDAO;

    // Constructor injection or setter injection for FoodTypeDAO
    public FoodTypeService() {
        this.foodTypeDAO =  new FoodTypeDao();
    }

    public List<FoodType> getAllFoodTypes() {
        return foodTypeDAO.getAllFoodTypes();
    }
}
