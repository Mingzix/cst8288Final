package dao;

import food.User;
import utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;  
import java.sql.ResultSet;  
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.text.SimpleDateFormat;

/**
 * The UserDao class provides methods to interact with user entities in the database.
 * @author Zoe Zhou
 */
public class UserDao {  
      

	/**
     * Adds a new user to the database.
     *
     * @param user The User object representing the user to be added.
     * @return The number of rows affected (1 if successful, 0 otherwise).
     */
    public int addUser(User user) {
        ;
        String sql = "INSERT INTO user (uid, NAME, email, PASSWORD, user_type) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = JDBCUtils.getConnection();PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setInt(1, user.getUid());
            preparedStatement.setString(2, user.getName());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setString(5, user.getUserType());
              
            int update = preparedStatement.executeUpdate();
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    long id = generatedKeys.getLong(1);
                    user.setUid((int) id);
                    JDBCUtils.close(generatedKeys,null,null);
                }
                    JDBCUtils.close(preparedStatement, connection);
            return update;
        }  catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }
    /**
     * Updates the last login time for a user.
     *
     * @param uid The ID of the user whose last login time is to be updated.
     */
    public void updateLastTime(int uid){
        String sql = "UPDATE user SET last_login = ? WHERE uid = ?";
        try (Connection connection = JDBCUtils.getConnection();PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setTimestamp(1, new Timestamp(System.currentTimeMillis()));
            preparedStatement.setInt(2, uid);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    /**
     * Retrieves a user from the database by name and password.
     *
     * @param name     The name of the user.
     * @param password The password of the user.
     * @return The User object if found, null otherwise.
     */
    public User getUserByNameAndPassword(String name, String password) {


        String sql = "SELECT * FROM user WHERE NAME = ? AND PASSWORD = ?";
        try (Connection connection = JDBCUtils.getConnection();PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, name);  
            preparedStatement.setString(2, password);
            User user =null;
            SimpleDateFormat sdf = new SimpleDateFormat("MM-dd HH:mm:ss");
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {  
                    // create the user
                    user = new User();
                    user.setUid(resultSet.getInt("uid"));
                    user.setName(resultSet.getString("NAME"));  
                    user.setEmail(resultSet.getString("email"));  
                    user.setPassword(resultSet.getString("PASSWORD"));  
                    user.setUserType(resultSet.getString("user_type"));
                    Timestamp timestamp = resultSet.getTimestamp("last_login");
                    if(timestamp!=null) {
                        user.setLastLogin(sdf.format(timestamp));
                    }
                }
                JDBCUtils.close(resultSet, preparedStatement, connection);
                return user;
            }  
        }catch (SQLException e){
            e.printStackTrace();
        }
        // if not found, return null  
        return null;  
    }

    /**
     * Retrieves a list of users from the database by their IDs.
     *
     * @param uids The list of user IDs.
     * @return A list of User objects representing the users found.
     */
    public List<User> getByUids(List<Integer> uids) {
        //based on the ids the get the user
        List<User> users = new ArrayList<>();

        String placeholders = String.join(", ", Collections.nCopies(uids.size(), "?"));
        String sql = "SELECT * FROM user WHERE uid IN (" + placeholders + ")";

        try (Connection conn = JDBCUtils.getConnection();PreparedStatement pstmt = conn.prepareStatement(sql)) {
            for (int i = 0; i < uids.size(); i++) {
                pstmt.setString(i + 1, uids.get(i).toString());
            }
            SimpleDateFormat sdf = new SimpleDateFormat("MM-dd HH:mm:ss");
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    String uid = rs.getString("uid");
                    String name = rs.getString("name");
                    String email = rs.getString("email");
                    String password = rs.getString("password");
                    String userType = rs.getString("user_type");
                    Timestamp lastLogin = rs.getTimestamp("last_login");
                    User user = new User();
                    user.setUid(Integer.parseInt(uid));
                    user.setName(name);
                    user.setEmail(email);
                    user.setPassword(password);
                    user.setUserType(userType);
                    if(lastLogin!=null) {
                        user.setLastLogin(sdf.format(lastLogin));
                    }
                    users.add(user);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return users;
    }
}
