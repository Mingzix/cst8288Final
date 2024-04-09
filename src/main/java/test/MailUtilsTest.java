package test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;

import utils.MailUtils;

import java.util.HashSet;

/**
 * Test class for MailUtils.
 * 
 * @author Shuting Wang
 */

public class MailUtilsTest {

    @Test
    public void testSendEmailWithEmptyEmailList() {
        // Prepare test data
        HashSet<String> emptyEmails = new HashSet<>();
        String title = "Test Title";
        String content = "Test Content";

        // Execute the method under test
        boolean result = MailUtils.sendEmail(emptyEmails, title, content);

        // Assert the result
        assertFalse(result, "The result should be false when the email list is empty.");
    }
}
