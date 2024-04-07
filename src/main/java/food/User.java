package food;

import java.sql.Timestamp;

public class User {
    private int uid;  
    private String name;  
    private String email;  
    private String password;  
    private String userType;
    private String lastLogin;
 public String getLastLogin() {
        return lastLogin;
    }
public void setLastLogin(String lastLogin) {
        this.lastLogin = lastLogin;
    }

public User(String name, String email, String password, String userType) {
    this.name = name;
    this.email = email;
    this.password = password;
    this.userType = userType;
}

public User() {
}
// Getter and Setter 
    public int getUid() {  
        return uid;  
    }  

    public void setUid(int uid) {  
        this.uid = uid;  
    }  

    public String getName() {  
        return name;  
    }  

    public void setName(String name) {  
        this.name = name;  
    }  

    public String getEmail() {  
        return email;  
    }  

    public void setEmail(String email) {  
        this.email = email;  
    }  

    public String getPassword() {  
        return password;  
    }  

    public void setPassword(String password) {  
        this.password = password;  
    }  

    public String getUserType() {  
        return userType;  
    }  

    public void setUserType(String userType) {  
        this.userType = userType;  
    }

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
