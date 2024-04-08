/**
 * The {@code Orders} class represents an order entity.
 * It encapsulates information about an order, including its ID, user ID, food ID,
 * amount of money, and number of items ordered.
 * <p>
 * An order typically consists of one or more food items purchased by a user.
 * </p>
 * 
 * @author Tao Chen
 * @version 2.0
 * @version Mar. 28th 2024
 */
package food;

import java.math.BigDecimal;

public class Orders {
    private int oid;  
    private int uid;
    private int fid; //
    private BigDecimal money;
    private int num;

   
    /**
     * Constructs an empty {@code Orders} object.
     */
    public Orders() {
    }  
    /**
     * Constructs an {@code Orders} object with the specified parameters.
     * 
     * @param oid    the order ID
     * @param uid    the user ID associated with the order
     * @param fid    the food ID associated with the order
     * @param money  the total amount of money for the order
     * @param num    the number of items ordered
     */
    public Orders(int oid, Integer uid, Integer fid, BigDecimal money,int num) {
        this.oid = oid;  
        this.uid = uid;  
        this.fid = fid;  
        this.money = money;
        this.num = num;
    } 
    /**
     * Sets the user ID associated with the order.
     * 
     * @param uid the user ID to set
     */
    public void setUid(int uid) {
        this.uid = uid;
    }
    /**
     * Sets the food ID associated with the order.
     * 
     * @param fid the food ID to set
     */
    public void setFid(int fid) {
        this.fid = fid;
    }
    /**
     * Returns the number of items ordered.
     * 
     * @return the number of items ordered
     */
    public int getNum() {
        return num;
    }
    
    /**
     * Sets the number of items ordered.
     * 
     * @param num the number of items ordered to set
     */
    public void setNum(int num) {
        this.num = num;
    }
    /**
     * Returns the order ID.
     * 
     * @return the order ID
     */
    public int getOid() {  
        return oid;  
    }  
    /**
     * Sets the order ID.
     * 
     * @param oid the order ID to set
     */
    public void setOid(int oid) {  
        this.oid = oid;  
    }  
    /**
     * Returns the user ID associated with the order.
     * 
     * @return the user ID
     */
    public Integer getUid() {  
        return uid;  
    }  
  
    public void setUid(Integer uid) {  
        this.uid = uid;  
    }  
    /**
     * Returns the food ID associated with the order.
     * 
     * @return the food ID
     */
    public Integer getFid() {  
        return fid;  
    }  
  
    public void setFid(Integer fid) {  
        this.fid = fid;  
    }  
    /**
     * Returns the total amount of money for the order.
     * 
     * @return the total amount of money
     */
    public BigDecimal getMoney() {  
        return money;  
    }  
    /**
     * Sets the total amount of money for the order.
     * 
     * @param money the total amount of money to set
     */
    public void setMoney(BigDecimal money) {  
        this.money = money;  
    }  
  
    /**
     * Returns a string representation of the {@code Orders} object.
     * 
     * @return a string representation of the object
     */
    @Override  
    public String toString() {  
        return "Order{" +  
                "oid=" + oid +  
                ", uid=" + uid +  
                ", fid=" + fid +  
                ", money=" + money +  
                '}';  
    }  
}