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

public class MailUtils {

    // Email protocol
    private static final String emailProtocol = "smtp";
    // SMTP server address of the sender
    private static final String emailSMTPHost = "smtp.qq.com";
    // Port
    private static final String emailPort = "465";
    // Sender's email address
    private static final String emailAccount = "ldswhyd90@qq.com"; 
    // Sender's email authorization code
    private static final String emailPassword = "qyqyybqfudknhbee";

    /**
     * Send an email
     *
     * @param emails  Target email addresses
     * @param title   Email subject
     * @param content Email content
     */
    public static boolean sendEmail(Set<String> emails, String title, String content) {
        // Return directly if no recipient email address is passed
        if (emails == null || emails.isEmpty()) return false;
        try {
            // 1. Create configuration parameters, used for connecting to the email server
            Properties props = new Properties();
            props.setProperty("mail.transport.protocol", emailProtocol); // Protocol used (JavaMail specification requirement)
            props.setProperty("mail.smtp.host", emailSMTPHost); // Specify the SMTP server address
            props.setProperty("mail.smtp.port", emailPort); // Specify the SMTP port number
            // Use SMTP authentication
            props.setProperty("mail.smtp.auth", "true"); // Require authentication
            props.put("mail.smtp.ssl.enable", "true"); // Enable SSL
            props.put("mail.smtp.ssl.protocols", "TLSv1.2"); // Specify SSL version
            props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            // Since Properties does not limit the request time by default, which may cause thread blocking, specify the request duration
            props.setProperty("mail.smtp.connectiontimeout", "10000");// Time limit to establish a connection with the mail server
            props.setProperty("mail.smtp.timeout", "10000");// Time limit for SMTP reading from the mail server
            props.setProperty("mail.smtp.writetimeout", "10000");// Time limit for uploading mail content
            // 2. Create a session object according to the configuration, used for interacting with the email server
            Session session = Session.getDefaultInstance(props);
            session.setDebug(false); // Set to debug mode, can view detailed send log
            // 3. Create an email message
            MimeMessage message = new MimeMessage(session);
            // 4. From: Sender (to avoid being mistaken by the mail server as spam due to nickname advertisement, please modify the nickname)
            message.setFrom(new InternetAddress(emailAccount, "retailer", "UTF-8"));
            // 5. To: Recipient(s) (you can add multiple recipients, CC, and BCC)
            int size = emails.size();
            // Single or multiple targets
            if (size == 1) {
                String email = emails.iterator().next();
                message.setRecipient(Message.RecipientType.TO, new InternetAddress(email, email, "UTF-8"));
            } else {
                InternetAddress[] addresses = new InternetAddress[emails.size()];
                int i = 0;
                for (String email : emails) {
                    addresses[i++] = new InternetAddress(email, email, "UTF-8");
                }
                message.setRecipients(MimeMessage.RecipientType.TO, addresses);
            }
            // 6. Subject: Email subject (to avoid being mistaken by the mail server as spam due to advertisement suspicion, please modify the subject)
            message.setSubject(title, "UTF-8");
            // 7. Content: Email body (HTML tags can be used) (to avoid being mistaken by the mail server as spam due to advertisement suspicion, please modify the content)
            message.setContent(content, "text/html;charset=UTF-8");
            // 8. Set the sending time
            message.setSentDate(new Date());
            // 9. Save changes
            message.saveChanges();
            // 10. Obtain the Transport object from the Session to send the email
            Transport transport = session.getTransport();
            transport.connect(emailAccount, emailPassword);
            // 11. Send the email, sent to all added recipients, CC, and BCC
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
