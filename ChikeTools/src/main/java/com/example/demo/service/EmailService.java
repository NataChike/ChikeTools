package com.example.demo.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ContactForm;

@Service
public class EmailService {
    private final JavaMailSender mailSender;
    public EmailService(JavaMailSender mailSender) { this.mailSender = mailSender; }

    public void sendContactEmail(ContactForm form) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo("chiketools@gmail.com");
        msg.setFrom("chiketools@gmail.com");
        msg.setReplyTo(form.getEmail());
        msg.setSubject("[問い合わせ] " + form.getSubject());
        msg.setText("送信者: " + form.getName() + "\n" +
                    "メール: " + form.getEmail() + "\n\n" +
                    form.getMessage());
        mailSender.send(msg);
    }
}
