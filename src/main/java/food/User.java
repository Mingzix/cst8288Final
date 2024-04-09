package food;

import java.sql.Timestamp;
/**
 * The User class represents a user in the system.
 * @author Zoe Zhou
 */
public class User {
    private int uid;  
    private String name;  
    private String email;  
    private String password;  
    private String userType;
    private String lastLogin;
    /**
     * Retrieves the timestamp of the user's last login.
     *
     * @return The timestamp of the user's last login.
     */
    public String getLastLogin() {
	        return lastLogin;
	    }
    /**
     * Sets the timestamp of the user's last login.
     *
     * @param lastLogin The timestamp to be set.
     */
	public void setLastLogin(String lastLogin) {
	        this.lastLogin = lastLogin;
	    }
	/**
     * Constructs a new User object with the specified name, email, password, and user type.
     *
     * @param name     The name of the user.
     * @param email    The email address of the user.
     * @param password The password of the user.
     * @param userType The type of the user.
     */
	public User(String name, String email, String password, String userType) {
	    this.name = name;
	    this.email = email;
	    this.password = password;
	    this.userType = userType;
	}
	/**
     * Constructs a new User object with default values.
     */
	public User() {
	}
	// Getter and Setter
	/**
     * Retrieves the unique identifier of the user.
     *
     * @return The ID of the user.
     */
    public int getUid() {  
        return uid;  
    }  
    /**
     * Sets the unique identifier of the user.
     *
     * @param uid The ID to be set.
     */
    public void setUid(int uid) {  
        this.uid = uid;  
    }  
    /**
     * Retrieves the name of the user.
     *
     * @return The name of the user.
     */
    public String getName() {  
        return name;  
    }  
    /**
     * Sets the name of the user.
     *
     * @param name The name to be set.
     */
    public void setName(String name) {  
        this.name = name;  
    }  
    /**
     * Retrieves the email address of the user.
     *
     * @return The email address of the user.
     */
    public String getEmail() {  
        return email;  
    }  
    /**
     * Sets the email address of the user.
     *
     * @param email The email address to be set.
     */
    public void setEmail(String email) {  
        this.email = email;  
    }  
    /**
     * Retrieves the password of the user.
     *
     * @return The password of the user.
     */
    public String getPassword() {  
        return password;  
    }  
    /**
     * Sets the password of the user.
     *
     * @param password The password to be set.
     */
    public void setPassword(String password) {  
        this.password = password;  
    }  
    /**
     * Retrieves the type of the user.
     *
     * @return The type of the user.
     */
    public String getUserType() {  
        return userType;  
    }  
    /**
     * Sets the type of the user.
     *
     * @param userType The type to be set.
     */
    public void setUserType(String userType) {  
        this.userType = userType;  
    }
    /**
     * Returns a string representation of the User object.
     *
     * @return A string containing the user's ID, name, email, password, and user type.
     */
	@Override
	public String toString() {
	    return "User{" +
            "uid=" + uid +
            ", name='" + name + '\'' +
            ", email='" + email + '\'' +
            ", password='" + password + '\'' +
            ", userType='" + userType + '\'' +
            '}';
	}
}
