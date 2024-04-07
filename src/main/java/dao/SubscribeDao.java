package dao;

import food.Subscribe;
import utils.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SubscribeDao {


    public int addSubscribe(Subscribe subscribe) {
        String sql = "INSERT INTO subscribe (sid, uid, fid, create_time) VALUES (?, ?, ?, ?)";  
        try (Connection connection = JDBCUtils.getConnection();PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, subscribe.getSid());  
            preparedStatement.setInt(2, subscribe.getUid() );
            preparedStatement.setInt(3, subscribe.getFid());  
            preparedStatement.setDate(4, new Date(System.currentTimeMillis()));
            int executeUpdate = preparedStatement.executeUpdate();
            JDBCUtils.close(preparedStatement, connection);
            return executeUpdate;
        } catch (SQLException e) {  
            e.printStackTrace();  
        }
        return 0;
    }  
  
    public int deleteSubscribesByFid(int fid) {
        String sql = "DELETE FROM subscribe WHERE fid = ?";  
        try (Connection connection = JDBCUtils.getConnection();PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, fid);
            int executeUpdate = preparedStatement.executeUpdate();
            JDBCUtils.close(preparedStatement, connection);
            return executeUpdate;
        } catch (SQLException e) {  
            e.printStackTrace();  
        }
        return 0;
    }

    public int removeSubscribe(Subscribe subscribe) {
        String sql = "DELETE FROM subscribe WHERE uid = ? AND fid = ?";
        try (Connection connection = JDBCUtils.getConnection();PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, subscribe.getUid());
            preparedStatement.setInt(2, subscribe.getFid());
            int executeUpdate = preparedStatement.executeUpdate();
            JDBCUtils.close(preparedStatement, connection);
            return executeUpdate;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //based on the fid query the subscribe table
    public List<Subscribe> getSubscribesByFid(int fid) {
        List<Subscribe> subscribes = new ArrayList<>();

        String sql = "SELECT sid, uid, fid, create_time FROM subscribe WHERE fid = ?";
        try (Connection conn = JDBCUtils.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, fid);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    int sid = rs.getInt("sid");
                    int uid = rs.getInt("uid");
                    int currentFid = rs.getInt("fid");
                    Date createTime = rs.getDate("create_time");
                    Subscribe subscribe = new Subscribe(sid, uid, currentFid, createTime);
                    subscribes.add(subscribe);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return subscribes;
    }

}