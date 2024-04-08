package utils;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.Properties;

/**
 * Utility class for sending emails using the SMTP protocol with a Gmail account.
 * This class configures and sends emails to one or multiple recipients.
 * 
 * <p>References for sending email in Java:</p>
 * <ul>
 *     <li>
 *         Sending Email in Java:
 *         <a href="https://javatpoint.com/example-of-sending-email-using-java-mail-api">https://javatpoint.com/example-of-sending-email-using-java-mail-api</a>
 *     </li>
 *     <li>
 *         JavaMail Example - Send Mail in Java using SMTP:
 *         <a href="https://www.digitalocean.com/community/tutorials/javamail-example-send-mail-in-java-smtp">https://www.digitalocean.com/community/tutorials/javamail-example-send-mail-in-java-smtp</a>
 *     </li>
 * </ul>
 * 
 * @author Shuting Wang
 */
public class MailUtils {

    // Email protocol
    private static final String emailProtocol = "smtp";
    // SMTP server address of the sender (Gmail)
    private static final String emailSMTPHost = "smtp.gmail.com";
    // Port number
    private static final String emailPort = "587";
    // Sender's email address
    private static final String emailAccount = "cst8288robot@gmail.com"; // Gmail address
    // Sender's email authorization code
    private static final String emailPassword = "jakezyzcwgycthez"; // Gmail application password

    /**
     * Sends an email to the specified list of recipients.
     * This method configures and sends an email using the SMTP protocol. It supports sending emails to multiple recipients.
     *
     * @param emails  A {@link Set} of target email addresses to whom the email will be sent. Cannot be {@code null} or empty.
     * @param title   The title (subject) of the email. Cannot be {@code null}.
     * @param content The content (body) of the email, which can include HTML. Cannot be {@code null}.
     * @return {@code true} if the email was sent successfully; {@code false} otherwise.
     */
    public static boolean sendEmail(Set<String> emails, String title, String content) {
        // Directly return if no recipient email addresses are passed
        if (emails == null || emails.isEmpty()) return false;
        try {
            // 1. Create parameter configuration, used for connecting to the email server
            Properties props = new Properties();
            props.setProperty("mail.transport.protocol", emailProtocol); // Protocol used (as required by JavaMail specification)
            props.setProperty("mail.smtp.host", emailSMTPHost); // SMTP server address
            props.setProperty("mail.smtp.port", emailPort); // SMTP port number
            // Use SMTP authentication
            props.setProperty("mail.smtp.auth", "true"); // Requires authentication
            props.put("mail.smtp.starttls.enable", "true");
            // Specify the timeout as Properties does not limit request time by default, which may cause thread blocking
            props.setProperty("mail.smtp.connectiontimeout", "10000"); // Connection establishment timeout with the email server
            props.setProperty("mail.smtp.timeout", "10000"); // SMTP read timeout
            props.setProperty("mail.smtp.writetimeout", "10000"); // Email content upload timeout
            // 2. Based on the configuration, create a session object for interacting with the mail server
            Session session = Session.getDefaultInstance(props);
            session.setDebug(false); // Set to debug mode to view detailed sending logs
            // 3. Create an email
            MimeMessage message = new MimeMessage(session);
            // 4. From: Sender
            message.setFrom(new InternetAddress(emailAccount, "retailer", "UTF-8"));
            // 5. To: Recipient(s) (can add multiple recipients, CC, BCC)
            int size = emails.size();
            // Determine if there's a single target email or multiple
            if (size == 1) {
                String email = emails.iterator().next();
                message.setRecipient(Message.RecipientType.TO, new InternetAddress(email, email, "UTF-8"));
            } else {
                InternetAddress[] addresses = new InternetAddress[size];
                int i = 0;
                for (String email : emails) {
                    addresses[i++] = new InternetAddress(email, email, "UTF-8");
                }
                message.setRecipients(MimeMessage.RecipientType.TO, addresses);
            }
            // 6. Subject: Email subject
            message.setSubject(title, "UTF-8");
            // 7. Content: Email body
            message.setContent(content, "text/html;charset=UTF-8");
            // 8. Set the sending time
            message.setSentDate(new Date());
            // 9. Save settings
            message.saveChanges();
            // 10. Obtain the mail transport object based on the Session
            Transport transport = session.getTransport();
            transport.connect(emailAccount, emailPassword);
            // 11. Send the email to all added recipients, CCs, and BCCs
            transport.sendMessage(message, message.getAllRecipients());
            // 12. Close the transport connection
            transport.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
