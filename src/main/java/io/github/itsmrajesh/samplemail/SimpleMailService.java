package io.github.itsmrajesh.samplemail;

public class SimpleMailService {

	/**
	 * SimpleMailService is utility class which allows you to send mail to recipient. You
	 * need to implement MailAuth Interface and pass it as argument to Method
	 * sendMailService(). sendMailService() method returns true if mail send
	 * successfully.
	 * 
	 * Developer(M Rajesh): https://github.com/itsmrajesh
	 */

	public static boolean sendMail(MailAuth mailAuth, String recipientMailAddress, String mailSubject, String message) {
		if (mailAuth != null) {
			Mailer mailer = new Mailer();
			return mailer.sendMail(mailAuth, recipientMailAddress, mailSubject, message);
		}
		return false;
	}

}