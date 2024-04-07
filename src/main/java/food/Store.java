package food;

public class Store {
    private int storeId;  
    private String storeName;  
    private String city;  
    private int uid;  
  
    // 构造方法  
    public Store() {  
    }  
  
    public Store(int storeId, String storeName, String city, int uid) {  
        this.storeId = storeId;  
        this.storeName = storeName;  
        this.city = city;  
        this.uid = uid;  
    }  
  
    // Getter和Setter方法  
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
  
    // toString方法，方便打印对象信息  
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