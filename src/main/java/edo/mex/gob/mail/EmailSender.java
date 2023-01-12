package edo.mex.gob.mail;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailSender {
    public static void main(String[] args) {
        // Your email and password
        String myEmail = "depdireccionmujer@gmail.com";
        String myPassword = "rjszameexkcsujod";

        // Email information
        String recipient = "edgar.ocampo.b@gmail.com";
        String subject = "Email subject";
        String body = "This is the email body";

        sendEmail(myEmail, myPassword, recipient, subject, body);
    }

    private static void sendEmail(String myEmail, String myPassword, String recipient, String subject, String body) {
        // Email account configuration
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

            System.out.println("The email has been sent successfully");
        } catch (MessagingException e) {
            System.out.println("There was an error sending the email: " + e.getMessage());
        }
    }
}
