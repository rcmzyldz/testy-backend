package be.intecbrussel.testy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;

@Configuration
public class MailConfig {

    @Bean
    public SimpleMailMessage templateSimpleMessage() {
        final var message = new SimpleMailMessage();
        message.setText("This is the test email from Intec Brussel.\n");
        return message;
    }

}
