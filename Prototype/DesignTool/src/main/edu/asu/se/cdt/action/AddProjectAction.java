package main.edu.asu.se.cdt.action;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class AddProjectAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String descritption;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescritption() {
		return descritption;
	}
	public void setDescritption(String descritption) {
		this.descritption = descritption;
	}
	public String execute(){
		if(getName()==null || getName().trim().equals("")){			
			return Action.INPUT;
		}else{
			return Action.SUCCESS;
		}
		
	}

}
