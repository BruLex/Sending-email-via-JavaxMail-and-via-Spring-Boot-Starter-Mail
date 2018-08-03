package javaxmail;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

public class Application {

    public static void main(String[] args) {
        final String fromEmail = "test@gmail.com"; // gmail id
        final String password = "test"; // password for gmail id
        final String toEmail = "example@gmail.com"; // email id to send

        System.out.println("TLSEmail Start");
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
        props.put("mail.smtp.port", "587"); //TLS Port
        props.put("mail.smtp.auth", "true"); //enable authentication
        props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS

        Authenticator auth = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        };
        Session session = Session.getInstance(props, auth);
        String subject = "Test sending mail message from Java application with JavaxMail";
        String body = "I can send email to everybody))";

        EmailUtil.sendEmail(session, toEmail, subject, body);

    }

}