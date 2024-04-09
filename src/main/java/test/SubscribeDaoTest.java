package test;
import dao.SubscribeDao;
import food.Subscribe;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test class for SubscribeDao.
 * 
 * @author Shuting Wang
 */

public class SubscribeDaoTest {
    private SubscribeDao subscribeDao;
    private Subscribe testSubscribe;

    @BeforeEach
    public void setUp() throws Exception {
        subscribeDao = new SubscribeDao();
        // Initialize test subscription data
        testSubscribe = new Subscribe(1, 1, 1, new Date());
        // Clean up and set up the test environment
        try (Connection connection = JDBCUtils.getConnection();
             PreparedStatement statement = connection.prepareStatement("DELETE FROM subscribe")) {
            statement.executeUpdate();
        }
        // Add a test subscription
        subscribeDao.addSubscribe(testSubscribe);
    }

    @AfterEach
    public void tearDown() throws Exception {
        // Clean up the database after tests
        try (Connection connection = JDBCUtils.getConnection();
             PreparedStatement statement = connection.prepareStatement("DELETE FROM subscribe")) {
            statement.executeUpdate();
        }
    }

    @Test
    public void testAddSubscribe() throws Exception {
        Subscribe newSubscribe = new Subscribe(2, 2, 2, new Date());
        int result = subscribeDao.addSubscribe(newSubscribe);
        assertEquals(1, result, "Should successfully insert one record");
    }

    @Test
    public void testDeleteSubscribesByFid() throws Exception {
        int result = subscribeDao.deleteSubscribesByFid(testSubscribe.getFid());
        assertTrue(result >= 1, "Should delete at least one subscription record");
    }

    @Test
    public void testRemoveSubscribe() throws Exception {
        int result = subscribeDao.removeSubscribe(testSubscribe);
        assertEquals(1, result, "Should successfully delete one subscription record");
    }

    @Test
    public void testGetSubscribesByFid() throws Exception {
        List<Subscribe> subscribes = subscribeDao.getSubscribesByFid(testSubscribe.getFid());
        assertTrue(subscribes.size() >= 1, "Should retrieve at least one subscription record");
    }
}
