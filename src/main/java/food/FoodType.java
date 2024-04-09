package food;
/**
 * The FoodType class represents a type of food.
 * @author Mingzi XU
 * @version 1.1
 */
public class FoodType {
    private int id;
    private String name;

    /**
     * Retrieves the unique identifier of the food type.
     *
     * @return The ID of the food type.
     */    public int getId() {
        return id;
    }
     /**
      * Sets the unique identifier of the food type.
      *
      * @param id The ID to be set.
      */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * Retrieves the name of the food type.
     *
     * @return The name of the food type.
     */
    public String getName() {
        return name;
    }
    /**
     * Sets the name of the food type.
     *
     * @param name The name to be set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns a string representation of the FoodType object.
     *
     * @return A string containing the ID and name of the food type.
     */    @Override
    public String toString() {
        return "FoodType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}