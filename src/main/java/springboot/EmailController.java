package springboot;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;


@Service
public class EmailController {

    @Autowired
    private JavaMailSender emailSender;

    public void sendSimpleMessage(final Mail mail) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject(mail.getSubject());
        message.setText(mail.getContent());
        message.setTo(mail.getTo());
        message.setFrom(mail.getFrom());
        emailSender.send(message);
    }

}
