package pl.projekty.database;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Admin {

	@GeneratedValue
    @Id
    private Long id;
	@Column
	private String login;
	@Column
	private Boolean authorizedToAdd;
	@Column
	private Boolean authorizedToSee;
	
	public String getLogin(){
		return login;
	}
	public void setLogin(String login){
		this.login = login;
	}
	public void setAuthorizedToAdd(Boolean authorizedToAdd){
		this.authorizedToAdd = authorizedToAdd;
	}
	public Boolean getAuthorizedToAdd(){
		return authorizedToAdd;
	}
	public void setAuthorizedToSee(Boolean authorizedToSee){
		this.authorizedToSee = authorizedToSee;
	}
	public Boolean getAuthorizedToSee(){
		return authorizedToSee;
	}
	
	protected Admin(){	}
	
	public Admin(String login, Boolean authorizedToAdd, Boolean authorizedToSee){
		this.login = login;
		this.authorizedToAdd = authorizedToAdd;
		this.authorizedToSee = authorizedToSee;
	}
	
}
