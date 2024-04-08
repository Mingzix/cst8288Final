package food;

public class Store {
    private int storeId;  
    private String storeName;  
    private String city;  
    private int uid;  
  
    public Store() {  
    }  
  
    public Store(int storeId, String storeName, String city, int uid) {  
        this.storeId = storeId;  
        this.storeName = storeName;  
        this.city = city;  
        this.uid = uid;  
    }

    public Store(int uid, String storeName, String city) {
        this.uid = uid;
        this.storeName = storeName;
        this.city = city;
    }

    public int getStoreId() {  
        return storeId;  
    }  
  
    public void setStoreId(int storeId) {  
        this.storeId = storeId;  
    }  
  
    public String getStoreName() {  
        return storeName;  
    }  
  
    public void setStoreName(String storeName) {  
        this.storeName = storeName;  
    }  
  
    public String getCity() {  
        return city;  
    }  
  
    public void setCity(String city) {  
        this.city = city;  
    }  
  
    public int getUid() {  
        return uid;  
    }  
  
    public void setUid(int uid) {  
        this.uid = uid;  
    }  
  

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
