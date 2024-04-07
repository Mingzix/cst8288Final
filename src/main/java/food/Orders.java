package food;

import java.math.BigDecimal;

public class Orders {
    private int oid;  
    private int uid;
    private int fid; //
    private BigDecimal money;
    private int num;

    public void setUid(int uid) {
        this.uid = uid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    // 构造方法
    public Orders() {
    }  
  
    public Orders(int oid, Integer uid, Integer fid, BigDecimal money,int num) {
        this.oid = oid;  
        this.uid = uid;  
        this.fid = fid;  
        this.money = money;
        this.num = num;
    }  
  
    // Getter 和 Setter 方法  
    public int getOid() {  
        return oid;  
    }  
  
    public void setOid(int oid) {  
        this.oid = oid;  
    }  
  
    public Integer getUid() {  
        return uid;  
    }  
  
    public void setUid(Integer uid) {  
        this.uid = uid;  
    }  
  
    public Integer getFid() {  
        return fid;  
    }  
  
    public void setFid(Integer fid) {  
        this.fid = fid;  
    }  
  
    public BigDecimal getMoney() {  
        return money;  
    }  
  
    public void setMoney(BigDecimal money) {  
        this.money = money;  
    }  
  
    // toString 方法，用于调试和日志记录  
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