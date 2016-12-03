package main.edu.asu.se.cdt.ejb;

import java.util.Properties;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Session Bean implementation class MailBean
 */
@Stateless
@LocalBean
public class MailBean {

	 public void sendEmailNotification(String from, String username, String password, String to, String subject, String message) throws AddressException, MessagingException{
     	Properties 	p = System.getProperties();
     	p.put("mail.smtp.host", "smtp.gmail.com");
     	p.put("mail.smtp.auth", "true");
     	p.put("mail.smtp.port", "465");
     	p.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
     	p.put("mail.smtp.socketFactory.port", "465");
     	p.put("mail.smtp.socketFactory.fallback", "false");
     	
     	Session mailSess = Session.getDefaultInstance(p, null);
     	//mailSess.setDebug(true);
     	Message msg = new MimeMessage(mailSess);
     	msg.setFrom(new InternetAddress(from));
     	msg.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
     	msg.setContent(message, "text/html");
     	msg.setSubject(subject);
     	
     	Transport tns = mailSess.getTransport("smtp");
     	tns.connect("smtp.gmail.com", username, password);
     	tns.sendMessage(msg, msg.getAllRecipients());
     }
    

}
