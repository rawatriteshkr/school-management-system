package com.kipragno.tech.mail;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailUtil {
	
	public static void sendMail(String recepient, String response, String subject) throws MessagingException {
		Properties properties = new Properties();
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");
		
		String accountEmail = "*******@gmail.com";
		String password = "*****@gmail.com";

		Session session = Session.getInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(accountEmail, password);
			}
		});
		
		Message message  = prepareMessage(session, accountEmail, recepient, response, subject);
		Transport.send(message);
	}

	private static Message prepareMessage(Session session, String accountEmail, String recepient, String response, String subject) {
		Message message = new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress(accountEmail));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
			message.setSubject(subject);
			message.setText(response);
			return message;
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		return null;
	}
}
