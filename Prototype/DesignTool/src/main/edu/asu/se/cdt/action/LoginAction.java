package main.edu.asu.se.cdt.action;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	public String message;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String execute(){
		if((getUsername().equals("user1") && getPassword().equals("user1")) ||
			(getUsername().equals("user2") && getPassword().equals("user2")) ||
			(getUsername().equals("user3") && getPassword().equals("user3"))){
			message = "welcome " + username;
			return Action.SUCCESS;
		}
		else{
			message = "Incorrect login. Try again!!";
			//addActionError("Incorrect login. Try again!!");
			return Action.LOGIN;
		}	
	}
	
	public void validate(){
		if(getUsername()==null || getUsername().trim().equals(""))
			addFieldError("username", "Username cannot be blank");
		if(getPassword()==null || getPassword().trim().equals(""))
			addFieldError("password", "Password cannot be blank");
	}

}

