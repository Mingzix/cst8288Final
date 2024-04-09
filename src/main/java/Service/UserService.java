package Service;

import dao.UserDao;
import food.User;  
import java.sql.Connection;
import java.sql.SQLException; 
/**
 * The UserService class provides methods to handle user-related functionalities.
  * @author Zoe Zhou
 */
public class UserService {  
      
    private UserDao userDao;  
    /**
     * Constructs a new UserService object and initializes UserDao instance.
     */
    public UserService() {
        this.userDao = new UserDao();
    }  
    /**
     * Adds a new user to the database.
     *
     * @param user The User object representing the user to be added.
     * @return The number of rows affected in the database after the insertion operation.
     */ 
    public int addUser(User user) {
       return userDao.addUser(user);
    }  
    /**
     * Retrieves a user from the database by name and password.
     *
     * @param name     The name of the user.
     * @param password The password of the user.
     * @return The User object representing the retrieved user, or null if not found.
     */
    public User getUserByNameAndPassword(String name, String password){
        return userDao.getUserByNameAndPassword(name, password);  
    }  
    /**
     * Updates the last login time of a user in the database.
     *
     * @param uid The ID of the user whose last login time needs to be updated.
     */
    public void updateLastTime(int uid) {
        userDao.updateLastTime(uid);
    }

}
