package edo.mex.gob.mail;

import edo.mex.gob.repository.Connector;
import java.util.Properties;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailSender {

    static Logger logger = Logger.getLogger(Connector.class.getName());

    public static void sendEmail(String recipient, String subject, String body) {
        logger.info(String.format(
                "The email data --recipient: [{}] --subject: [{}] --body: [{}]",
                recipient,
                subject,
                body
        ));

        // Your email and password credentials
        final String myEmail = "depdireccionmujer@gmail.com";
        final String myPassword = "rjszameexkcsujod";

        // Email account properties configuration
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        // Email login
        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myEmail, myPassword);
            }
        });

        try {
            // Create email
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient));
            message.setSubject(subject);
            message.setText(body);

            // Send email
            Transport.send(message);
            logger.info(String.format(
                    "The email has been sent successfully --message: [{}]",
                    message
            ));
        } catch (MessagingException e) {
            logger.warning(String.format("There was an error sending the email --error[{}]", e.getMessage()));
        }
    }
}
