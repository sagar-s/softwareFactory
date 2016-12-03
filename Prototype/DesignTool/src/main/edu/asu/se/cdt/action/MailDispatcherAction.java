package main.edu.asu.se.cdt.action;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import main.edu.asu.se.cdt.ejb.MailBean;

public class MailDispatcherAction {
	private String email1;
	private String email2;
	private String email3;
	private String email4;
	private String role1;
	private String role2;
	private String role3;
	private String role4;
	private String startdate1;
	private String startdate2;
	private String startdate3;
	private String startdate4;
	private String enddate1;
	private String enddate2;
	private String enddate3;
	private String enddate4;
	private String message1;
	private String message2;
	private String message3;
	private String message4;
	private String subject;
	
	public String getEmail1() {
		return email1;
	}


	public void setEmail1(String email1) {
		this.email1 = email1;
	}


	public String getEmail2() {
		return email2;
	}


	public void setEmail2(String email2) {
		this.email2 = email2;
	}


	public String getEmail3() {
		return email3;
	}


	public void setEmail3(String email3) {
		this.email3 = email3;
	}


	public String getEmail4() {
		return email4;
	}


	public void setEmail4(String email4) {
		this.email4 = email4;
	}


	public String getRole1() {
		return role1;
	}


	public void setRole1(String role1) {
		this.role1 = role1;
	}


	public String getRole2() {
		return role2;
	}


	public void setRole2(String role2) {
		this.role2 = role2;
	}


	public String getRole3() {
		return role3;
	}


	public void setRole3(String role3) {
		this.role3 = role3;
	}


	public String getRole4() {
		return role4;
	}


	public void setRole4(String role4) {
		this.role4 = role4;
	}


	public String getStartdate1() {
		return startdate1;
	}


	public void setStartdate1(String startdate1) {
		this.startdate1 = startdate1;
	}


	public String getStartdate2() {
		return startdate2;
	}


	public void setStartdate2(String startdate2) {
		this.startdate2 = startdate2;
	}


	public String getStartdate3() {
		return startdate3;
	}


	public void setStartdate3(String startdate3) {
		this.startdate3 = startdate3;
	}


	public String getStartdate4() {
		return startdate4;
	}


	public void setStartdate4(String startdate4) {
		this.startdate4 = startdate4;
	}


	public String getEnddate1() {
		return enddate1;
	}


	public void setEnddate1(String enddate1) {
		this.enddate1 = enddate1;
	}


	public String getEnddate2() {
		return enddate2;
	}


	public void setEnddate2(String enddate2) {
		this.enddate2 = enddate2;
	}


	public String getEnddate3() {
		return enddate3;
	}


	public void setEnddate3(String enddate3) {
		this.enddate3 = enddate3;
	}


	public String getEnddate4() {
		return enddate4;
	}


	public void setEnddate4(String enddate4) {
		this.enddate4 = enddate4;
	}


	public String getMessage1() {
		return message1;
	}


	public void setMessage1(String message1) {
		this.message1 = message1;
	}


	public String getMessage2() {
		return message2;
	}


	public void setMessage2(String message2) {
		this.message2 = message2;
	}


	public String getMessage3() {
		return message3;
	}


	public void setMessage3(String message3) {
		this.message3 = message3;
	}


	public String getMessage4() {
		return message4;
	}


	public void setMessage4(String message4) {
		this.message4 = message4;
	}


	public String execute() throws AddressException, MessagingException{
		// properties to be read from external file 

		subject = "Notification for modifying use case";
		message1= "You have been added as " + role1 + " and is allowed to modify use case from start date= " + startdate1 + " till " + " end date= " +enddate1; 
		message2= "You have been added as " + role2 + " and is allowed to modify use case from start date= " + startdate2 + " till " + " end date= " +enddate2; 
		message3= "You have been added as " + role3 + " and is allowed to modify use case from start date= " + startdate3 + " till " + " end date= " +enddate3;
		message4= "You have been added as " + role4 + " and is allowed to modify use case from start date= " + startdate4 + " till " + " end date= " +enddate4;

		MailBean mb = new MailBean();
		mb.sendEmailNotification(fromEmail, username, password, email1, subject, message1);
		mb.sendEmailNotification(fromEmail, username, password, email2, subject, message2);
		mb.sendEmailNotification(fromEmail, username, password, email3, subject, message3);
		mb.sendEmailNotification(fromEmail, username, password, email4, subject, message3);
		return "success";
	}
}
