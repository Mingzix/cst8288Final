/**
 * The {@code Food} class represents a food item.
 * It contains various attributes such as ID, name, expiration date, price, inventory, discount, food type ID,
 * and store ID.
 * <p>
 * This class provides getters and setters for accessing and modifying its attributes.
 * </p>
 * 
 * @author Tao Chen, Mingzi XU
 * @version 1.1
 */
package food;

import java.math.BigDecimal;
import java.util.Date;

public class Food {
    private int fid;  
    private String fname;  
    private Date expiration;
    private BigDecimal price;
    private int inventory;  
    private double discount;  
    private int ftid;

    private int isDonate;
    private int storeId;

    /**
     * Constructs a new Food object with default values.
     */
    public Food() {  
        
    }  
    /**
     * Constructs a new Food object with specified values.
     * 
     * @param fid The ID of the food item.
     * @param fname The name of the food item.
     * @param expiration The expiration date of the food item.
     * @param price The price of the food item.
     * @param inventory The inventory quantity of the food item.
     * @param discount The discount percentage of the food item.
     * @param ftid The ID of the food type associated with the food item.
     */
    public Food(int fid, String fname, Date expiration, BigDecimal price, int inventory, double discount,int ftid) {
        this.fid = fid;  
        this.fname = fname;  
        this.expiration = expiration;  
        this.price = price;  
        this.inventory = inventory;  
        this.discount = discount;  
        this.ftid = ftid;
    }  

	// Getter and  Setter
    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public int getIsDonate() {
        return isDonate;
    }

    public void setIsDonate(int isDonate) {
        this.isDonate = isDonate;
    }
    /**
     * Retrieves the ID of the food item.
     * 
     * @return The ID of the food item.
     */
    public int getFid() {  
        return fid;  
    }  
    /**
     * Sets the ID of the food item.
     * 
     * @param fid The ID of the food item.
     */
    public void setFid(int fid) {  
        this.fid = fid;  
    }  
    /**
     * Retrieves the name of the food item.
     * 
     * @return The name of the food item.
     */
    public String getFname() {  
        return fname;  
    }  
    /**
     * Sets the name of the food item.
     * 
     * @param fname The name of the food item.
     */
    public void setFname(String fname) {  
        this.fname = fname;  
    }  
    /**
     * Retrieves the expiration date of the food item.
     * 
     * @return The expiration date of the food item.
     */
    public Date getExpiration() {  
        return expiration;  
    }  
    
    /**
     * Sets the expiration date of the food item.
     * 
     * @param expiration The expiration date of the food item.
     */
    public void setExpiration(Date expiration) {  
        this.expiration = expiration;  
    }  
    /**
     * Retrieves the price of the food item.
     * 
     * @return The price of the food item.
     */
    public BigDecimal getPrice() {  
        return price;  
    }  
    /**
     * Sets the price of the food item.
     * 
     * @param price The price of the food item.
     */
    public void setPrice(BigDecimal price) {  
        this.price = price;  
    }  
    /**
     * Retrieves the inventory quantity of the food item.
     * 
     * @return The inventory quantity of the food item.
     */
    public int getInventory() {  
        return inventory;  
    }  
    /**
     * Sets the inventory quantity of the food item.
     * 
     * @param inventory The inventory quantity of the food item.
     */
    public void setInventory(int inventory) {  
        this.inventory = inventory;  
    }  
    /**
     * Retrieves the discount percentage of the food item.
     * 
     * @return The discount percentage of the food item.
     */
    public double getDiscount() {  
        return discount;  
    }  
    /**
     * Sets the discount percentage of the food item.
     * 
     * @param discount The discount percentage of the food item.
     */
    public void setDiscount(double discount) {  
        this.discount = discount;  
    }
    /**
     * Retrieves the ID of the food type associated with the food item.
     * 
     * @return The ID of the food type.
     */
    public int getFtid() {
        return ftid;
    }
    /**
     * Sets the ID of the food type associated with the food item.
     * 
     * @param ftid The ID of the food type.
     */
    public void setFtid(int ftid) {
        this.ftid = ftid;
    }

}
