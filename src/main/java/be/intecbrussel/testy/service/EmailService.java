package be.intecbrussel.testy.service;

import java.util.Objects;
import java.util.Set;

import javax.mail.MessagingException;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final JavaMailSender emailSender;
    private final SimpleMailMessage simpleMessage;

    public EmailService(JavaMailSender emailSender, SimpleMailMessage simpleMessage) {
        this.emailSender = emailSender;
        this.simpleMessage = simpleMessage;
    }

    public void sendSimpleMessage(final String to, final String subject, final String text) {
        final var message = new SimpleMailMessage();
        message.setFrom("yilmaz.brievenbus@gmail.com");
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        emailSender.send(message);
    }

    public void sendTemplatedMessage(final String to, final String activation) {
        sendSimpleMessage(to, "Testy User Account Activation", "Welcome to Testy made by Intec Brussel Dev Team. Here is your activation code: " + activation);
    }

    public void sendMessageWithAttachment(String to, String subject, String text, FileSystemResource resource) {
        try {
            final var message = emailSender.createMimeMessage();
            // pass 'true' to the constructor to create a multipart message
            final var helper = new MimeMessageHelper(message, true);

            helper.setFrom("noreply@intecbrussel.be");
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(text);
            helper.addAttachment("Invoice", resource);

            emailSender.send(message);

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public void sendSimpleMessageUsingTemplate(String to, String subject, String... templateModel) {
        final var text = String.format(Objects.requireNonNull(simpleMessage.getText()), (Object[]) templateModel);
        sendSimpleMessage(to, subject, text);
    }

    private void sendHtmlMessage(String to, String subject, String htmlBody, final Set<Resource> resources)
            throws MessagingException {

        final var message = emailSender.createMimeMessage();
        final var helper = new MimeMessageHelper(message, true, "UTF-8");
        helper.setFrom("noreply@intecbrussel.be");
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(htmlBody, true);
        for (Resource r : resources) {
            helper.addInline("attachment.png", r);
        }
        emailSender.send(message);
    }
}
