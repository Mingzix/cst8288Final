package food;
/**
 * The Store class represents a store entity in the system.
 * It contains information such as store ID, name, city, and associated user ID. 
 * @author Tao Chen
 */

public class Store {
    private int storeId;  
    private String storeName;  
    private String city;  
    private int uid;  
    /**
     * Constructs a new Store object with default values.
     */
    public Store() {  
    }  
    /**
     * Constructs a new Store object with the specified parameters.
     *
     * @param storeId   The unique identifier of the store.
     * @param storeName The name of the store.
     * @param city      The city where the store is located.
     * @param uid       The unique identifier of the user associated with the store.
     */
    public Store(int storeId, String storeName, String city, int uid) {  
        this.storeId = storeId;  
        this.storeName = storeName;  
        this.city = city;  
        this.uid = uid;  
    }
    /**
     * Constructs a new Store object with the specified parameters, excluding storeId.
     *
     * @param uid       The unique identifier of the user associated with the store.
     * @param storeName The name of the store.
     * @param city      The city where the store is located.
     */
    public Store(int uid, String storeName, String city) {
        this.uid = uid;
        this.storeName = storeName;
        this.city = city;
    }
    /**
     * Retrieves the unique identifier of the store.
     *
     * @return The ID of the store.
     */
    public int getStoreId() {  
        return storeId;  
    }  
    /**
     * Sets the unique identifier of the store.
     *
     * @param storeId The ID to be set.
     */
    public void setStoreId(int storeId) {  
        this.storeId = storeId;  
    }  
    /**
     * Retrieves the name of the store.
     *
     * @return The name of the store.
     */
    public String getStoreName() {  
        return storeName;  
    }  
    /**
     * Sets the name of the store.
     *
     * @param storeName The name to be set.
     */
    public void setStoreName(String storeName) {  
        this.storeName = storeName;  
    }  
    /**
     * Retrieves the city where the store is located.
     *
     * @return The city of the store.
     */
    public String getCity() {  
        return city;  
    }  
   /**
    * Sets the city where the store is located.
    *
    * @param city The city to be set.
    */
  
    public void setCity(String city) {  
        this.city = city;  
    }  
    /**
     * Retrieves the unique identifier of the user associated with the store.
     *
     * @return The UID of the user.
     */
    public int getUid() {  
        return uid;  
    }  
    /**
     * Sets the unique identifier of the user associated with the store.
     *
     * @param uid The UID to be set.
     */
    public void setUid(int uid) {  
        this.uid = uid;  
    }  
  
    /**
     * Returns a string representation of the Store object.
     *
     * @return A string containing the store's ID, name, city, and UID.
     */
    @Override  
    public String toString() {  
        return "Store{" +  
                "storeId=" + storeId +  
                ", storeName='" + storeName + '\'' +  
                ", city='" + city + '\'' +  
                ", uid=" + uid +  
                '}';  
    }  
}
