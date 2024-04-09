package Service;

import java.util.List;

import dao.FoodTypeDao;
import food.FoodType;
/**
 * The FoodTypeService class provides methods to retrieve information about food types.
 * It interacts with the FoodTypeDao to fetch data from the underlying data source.
 * @author Mingzi Xu
 * @version 1.1
 * @since March 28, 2024
 *
 */
public class FoodTypeService {
    private FoodTypeDao foodTypeDAO;

    /**
     * Constructs a new FoodTypeService instance and initializes the FoodTypeDao.
     */
    public FoodTypeService() {
        this.foodTypeDAO =  new FoodTypeDao();
    }
    /**
     * Retrieves a list of all food types.
     * 
     * @return A List containing all food types.
     */
    public List<FoodType> getAllFoodTypes() {
        return foodTypeDAO.getAllFoodTypes();
    }
}
