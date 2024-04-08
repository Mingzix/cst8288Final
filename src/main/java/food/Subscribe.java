package food;

import java.util.Date;

/**
 * Represents a subscription entity, encapsulating details about a subscription.
 * This class includes properties for subscription ID, user ID, food item ID, and creation time.
 * 
 * @author Shuting Wang
 */
public class Subscribe {
    private int sid;
    private int uid;
    private int fid;
    private Date createTime;

    /**
     * Default constructor for creating an instance without setting any initial values.
     */
    public Subscribe() {
    }

    /**
     * Constructs a new Subscribe instance with specified details.
     *
     * @param sid The subscription ID.
     * @param uid The user ID associated with this subscription.
     * @param fid The food item ID associated with this subscription.
     * @param createTime The creation time of the subscription.
     */
    public Subscribe(int sid, Integer uid, Integer fid, Date createTime) {
        this.sid = sid;
        this.uid = uid;
        this.fid = fid;
        this.createTime = createTime;
    }

    // Getters and Setters

    /**
     * Returns the subscription ID.
     *
     * @return The subscription ID.
     */
    public int getSid() {
        return sid;
    }

    /**
     * Sets the subscription ID.
     *
     * @param sid The subscription ID to set.
     */
    public void setSid(int sid) {
        this.sid = sid;
    }

    /**
     * Returns the user ID.
     *
     * @return The user ID.
     */
    public int getUid() {
        return uid;
    }

    /**
     * Sets the user ID.
     *
     * @param uid The user ID to set.
     */
    public void setUid(int uid) {
        this.uid = uid;
    }

    /**
     * Returns the food item ID.
     *
     * @return The food item ID.
     */
    public int getFid() {
        return fid;
    }

    /**
     * Sets the food item ID.
     *
     * @param fid The food item ID to set.
     */
    public void setFid(int fid) {
        this.fid = fid;
    }

    /**
     * Returns the creation time of the subscription.
     *
     * @return The creation time.
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * Sets the creation time of the subscription.
     *
     * @param createTime The creation time to set.
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * Provides a string representation of the subscription entity.
     *
     * @return A string representation of the subscription entity.
     */
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
