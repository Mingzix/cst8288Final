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

    public int getIsDonate() {
        return isDonate;
    }

    public void setIsDonate(int isDonate) {
        this.isDonate = isDonate;
    }

    
    public Food() {  
        
    }  
  
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
    public int getFid() {  
        return fid;  
    }  
  
    public void setFid(int fid) {  
        this.fid = fid;  
    }  
  
    public String getFname() {  
        return fname;  
    }  
  
    public void setFname(String fname) {  
        this.fname = fname;  
    }  
  
    public Date getExpiration() {  
        return expiration;  
    }  
  
    public void setExpiration(Date expiration) {  
        this.expiration = expiration;  
    }  
  
    public BigDecimal getPrice() {  
        return price;  
    }  
  
    public void setPrice(BigDecimal price) {  
        this.price = price;  
    }  
  
    public int getInventory() {  
        return inventory;  
    }  
  
    public void setInventory(int inventory) {  
        this.inventory = inventory;  
    }  
  
    public double getDiscount() {  
        return discount;  
    }  
  
    public void setDiscount(double discount) {  
        this.discount = discount;  
    }

    public int getFtid() {
        return ftid;
    }

    public void setFtid(int ftid) {
        this.ftid = ftid;
    }



}