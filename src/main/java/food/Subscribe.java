package food;

import java.util.Date;

public class Subscribe {
    private int sid;  
    private int uid;
    private int fid;
    private Date createTime;
  
      
    public Subscribe() {  
        
    }  
  
    public Subscribe(int sid, Integer uid, Integer fid, Date createTime) {  
        this.sid = sid;  
        this.uid = uid;  
        this.fid = fid;  
        this.createTime = createTime;  
    }  
  
    // Getter and Setter
    public int getSid() {  
        return sid;  
    }  
  
    public void setSid(int sid) {  
        this.sid = sid;  
    }  
  
    public int getUid() {
        return uid;  
    }  
  
    public void setUid(int uid) {
        this.uid = uid;  
    }  
  
    public int getFid() {
        return fid;  
    }  
  
    public void setFid(int fid) {
        this.fid = fid;  
    }  
  
    public Date getCreateTime() {  
        return createTime;  
    }  
  
    public void setCreateTime(Date createTime) {  
        this.createTime = createTime;  
    }  
  
    // toString
    @Override  
    public String toString() {  
        return "Subscribe{" +  
                "sid=" + sid +  
                ", uid=" + uid +  
                ", fid=" + fid +  
                ", createTime=" + createTime +  
                '}';  
    }  
}