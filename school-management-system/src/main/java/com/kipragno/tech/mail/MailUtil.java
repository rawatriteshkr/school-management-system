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

	public static void sendMail(String recepient, String regno, String otp) throws MessagingException {
		Properties properties = new Properties();
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");
		
		String accountEmail = "*******@gmail.com";
		String password = "***********";
		
		Session session = Session.getInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(accountEmail, password);
			}
		});
		
		Message message  = prepareMessage(session, accountEmail, recepient, regno, otp);
		Transport.send(message);
	}

	private static Message prepareMessage(Session session, String accountEmail, String recepient, String regno, String otp) {
		Message message = new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress(accountEmail));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
			message.setSubject("Student Login Credentials");
			message.setText("Registration No : " + regno + "\n" + "Password : " + otp);
			return message;
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		return null;
	}
}
