package food;

/**
 * The FoodVo class represents a view object for food, extending the Food class.
 * It includes additional attributes such as foodType, isExpired, and isSubscribe.
 * @author Mingzi Xu
 * @since March 28, 2024
 */
public class FoodVo extends Food{
    private String foodType;

    private String isExpired;

    private int isSubscribe;
    /**
     * Retrieves the subscription status of the food.
     *
     * @return The subscription status (1 if subscribed, 0 otherwise).
     */
    public int getIsSubscribe() {
        return isSubscribe;
    }
    /**
     * Sets the subscription status of the food.
     *
     * @param isSubscribe The subscription status to be set (1 if subscribed, 0 otherwise).
     */
    public void setIsSubscribe(int isSubscribe) {
        this.isSubscribe = isSubscribe;
    }
    /**
     * Retrieves the expiration status of the food.
     *
     * @return The expiration status ("yes" if expired, "no" otherwise).
     */
    public String getIsExpired() {
        return isExpired;
    }
    /**
     * Sets the expiration status of the food.
     *
     * @param isExpired The expiration status to be set ("yes" if expired, "no" otherwise).
     */
    public void setIsExpired(String isExpired) {
        this.isExpired = isExpired;
    }
    /**
     * Retrieves the type of the food.
     *
     * @return The type of the food.
     */
    public String getFoodType() {
        return foodType;
    }
    /**
     * Sets the type of the food.
     *
     * @param foodType The type of the food to be set.
     */
    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }


}
