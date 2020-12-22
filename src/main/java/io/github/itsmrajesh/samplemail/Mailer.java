package io.github.itsmrajesh.samplemail;

import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Mailer {

	public boolean sendMail(MailAuth mail, String recipientmailaddress, String mailSubject, String message) {
		try {
			String host = "smtp.gmail.com";
			String from = mail.getHostMailAddress();
			String pass = mail.getHostPassword();
			String to = recipientmailaddress;
			String user = mail.getHostMailAddress();
			String subject = mailSubject;
			String BODY = String.join(System.getProperty("line.separator"), message);
			boolean sessionDebug = false;
			Properties props = System.getProperties();
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", host);
			props.put("mail.smtp.port", "587");
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.required", "true");
			Session mailSession = Session.getDefaultInstance(props, null);
			mailSession.setDebug(sessionDebug);
			Message msg = new MimeMessage(mailSession);
			msg.setFrom(new InternetAddress(from));
			InternetAddress[] address = { new InternetAddress(to) };
			msg.setRecipients(Message.RecipientType.TO, address);
			msg.setSubject(subject);
			msg.setSentDate(new Date());
			msg.setContent(BODY, "Text/html");
			Transport transport = mailSession.getTransport("smtp");
			transport.connect(host, user, pass);
			transport.sendMessage(msg, msg.getAllRecipients());
			transport.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Update: Allow less secure apps: ON");
			System.out.println("Make sure you have proper internet connection");
			System.out.println("Also check username/email and password");
			return false;
		}

	}

}
