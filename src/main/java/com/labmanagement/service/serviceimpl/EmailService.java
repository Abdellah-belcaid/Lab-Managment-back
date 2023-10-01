package com.labmanagement.service.serviceimpl;

import com.labmanagement.service.IEmailService;
import com.labmanagement.util.EmailUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService implements IEmailService {

    @Value("${spring.mail.verify.host}")
    private static String host;
    @Value("${spring.mail.username}")
    private static String fromEmail;
    private final JavaMailSender mailSender;

    @Override
    @Async
    public void SendSimpleMessage(String name, String to, String token) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setSubject("New User Verification ");
            message.setFrom(fromEmail);
            message.setTo(to);
            message.setText(EmailUtils.getVerificationEmailMessage(name, host, token));
            mailSender.send(message);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
