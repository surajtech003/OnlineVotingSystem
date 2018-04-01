/**
 * 
 */
package com.gof.voting.email;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * This {@link SenderMail} class is used to send mail for forgetPassword link.
 * 
 * @author suraj singh
 *
 */
public class SenderMail {
	
	private static String mail_host;
	
	private static String mail_port;
	
	private static String mail_auth;
	
	private static String mail_tls_enable;
	
	private static String subject;
	
	private static String messageBody;
	
	private static String username;
	
	private static String password;
	
	static {
		Properties properties = new Properties();
		try {
			properties.load(SenderMail.class.getClassLoader()
					.getResourceAsStream(EmailConstants.PROP_PATH_EMAIL));
			mail_host = properties.getProperty(EmailConstants.MAIL_HOST);
			mail_port = properties.getProperty(EmailConstants.MAIL_PORT);
			mail_auth = properties.getProperty(EmailConstants.MAIL_AUTH);
			mail_tls_enable = properties.getProperty(EmailConstants.MAIL_TLS_ENABLE);
			subject = properties.getProperty(EmailConstants.MAIL_SUBJECT);
			messageBody = properties.getProperty(EmailConstants.MAIL_BODY);
			username = properties.getProperty(EmailConstants.SENDER_USERNAME);
			password = properties.getProperty(EmailConstants.SENDER_PASSWORD);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param toMail
	 */
	public void sendMail(String toMail) {

		 Properties propsEmail = new Properties();
				
		 propsEmail.put("mail.smtp.host", mail_host);
	     //below mentioned mail.smtp.port is optional
		 propsEmail.put("mail.smtp.port", mail_port);		
		 propsEmail.put("mail.smtp.auth", mail_auth);
		 propsEmail.put("mail.smtp.starttls.enable", mail_tls_enable);
		
		
		Session session = Session.getInstance(propsEmail,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(username, password);
					}
				});

		try {

			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(
					toMail));
			message.setSubject(subject);
			message.setText(messageBody);

			/* Transport class is used to deliver the message to the recipients */
			Transport.send(message);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
