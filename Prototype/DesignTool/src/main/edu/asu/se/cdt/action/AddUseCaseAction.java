package main.edu.asu.se.cdt.action;

public class AddUseCaseAction {
	private String ucname;
	private String id;
	private String description;
	private String actors;
	private String subusecases;
	private String prerequirements;
	private String postrequirements;
	private String status;
	public String getUcname() {
		return ucname;
	}
	public void setUcname(String ucname) {
		this.ucname = ucname;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getActors() {
		return actors;
	}
	public void setActors(String actors) {
		this.actors = actors;
	}
	public String getSubusecases() {
		return subusecases;
	}
	public void setSubusecases(String subusecases) {
		this.subusecases = subusecases;
	}
	public String getPrerequirements() {
		return prerequirements;
	}
	public void setPrerequirements(String prerequirements) {
		this.prerequirements = prerequirements;
	}
	public String getPostrequirements() {
		return postrequirements;
	}
	public void setPostrequirements(String postrequirements) {
		this.postrequirements = postrequirements;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String execute(){
		return "success";
	}

}
