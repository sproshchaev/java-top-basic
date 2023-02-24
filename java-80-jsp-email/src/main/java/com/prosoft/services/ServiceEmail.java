package com.prosoft.services;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.util.Date;
import java.util.Properties;

public class ServiceEmail {
    public static void sendEmail(String host, String port, String user, String password, String address, String topic,
                                 String text) throws MessagingException, MessagingException, AddressException {
        Properties properties = new Properties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        Authenticator auth = new Authenticator() {
            public PasswordAuthentication
            getPasswordAuthentication() {
                return new PasswordAuthentication(user, password.toCharArray());
            }
        };
        Session session = Session.getInstance(properties);
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(user));
        InternetAddress[] addresses = {new InternetAddress(address)};
        message.setRecipients(Message.RecipientType.TO, addresses);
        message.setSubject(topic);
        message.setSentDate(new Date());
        message.setText(text);
        Transport.send(message);
    }
}
