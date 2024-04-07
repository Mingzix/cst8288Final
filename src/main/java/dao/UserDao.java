package dao;

import food.User;
import utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;  
import java.sql.ResultSet;  
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserDao {  
      


    public int addUser(User user) {
        ;
        String sql = "INSERT INTO user (uid, NAME, email, PASSWORD, user_type) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = JDBCUtils.getConnection();PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, user.getUid());
            preparedStatement.setString(2, user.getName());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setString(5, user.getUserType());
              
            int update = preparedStatement.executeUpdate();
            JDBCUtils.close(preparedStatement, connection);
            return update;
        }  catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }  
      
    public User getUserByNameAndPassword(String name, String password) {


        String sql = "SELECT * FROM user WHERE NAME = ? AND PASSWORD = ?";
        try (Connection connection = JDBCUtils.getConnection();PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, name);  
            preparedStatement.setString(2, password);
            User user =null;
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {  
                    // create the user
                    user = new User();
                    user.setUid(resultSet.getInt("uid"));
                    user.setName(resultSet.getString("NAME"));  
                    user.setEmail(resultSet.getString("email"));  
                    user.setPassword(resultSet.getString("PASSWORD"));  
                    user.setUserType(resultSet.getString("user_type"));
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


    public List<User> getByUids(List<Integer> uids) {
        //based on the ids the get the user
        List<User> users = new ArrayList<>();

        String placeholders = String.join(", ", Collections.nCopies(uids.size(), "?"));
        String sql = "SELECT uid, name, email, password, user_type FROM user WHERE uid IN (" + placeholders + ")";

        try (Connection conn = JDBCUtils.getConnection();PreparedStatement pstmt = conn.prepareStatement(sql)) {
            for (int i = 0; i < uids.size(); i++) {
                pstmt.setString(i + 1, uids.get(i).toString());
            }

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    String uid = rs.getString("uid");
                    String name = rs.getString("name");
                    String email = rs.getString("email");
                    String password = rs.getString("password");
                    String userType = rs.getString("user_type");

                    User user = new User();
                    user.setUid(Integer.parseInt(uid));
                    user.setName(name);
                    user.setEmail(email);
                    user.setPassword(password);
                    user.setUserType(userType);
                    users.add(user);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return users;
    }
}