package com.project.restaurant.database.email;

import com.project.restaurant.utils.Constants;
import lombok.AllArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
@AllArgsConstructor
public class EmailService implements IEmailSender {

    private final JavaMailSender mailSender;

    private final Constants constants;

    @Async
    @Override
    public void send(String to, String email) {
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();

            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
            helper.setText(email, true);
            helper.setFrom(constants.getEmailAddress());
            helper.setTo(to);
            helper.setSubject("CONFIRM YOUR EMAIL!");

            mailSender.send(mimeMessage);

        } catch (MessagingException e) {
            throw new IllegalStateException("EMAIL NOT SENT");
        }
    }
}
