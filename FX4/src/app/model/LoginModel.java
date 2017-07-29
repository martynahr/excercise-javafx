package app.model;

public class LoginModel {
	private String login;
	private String pass;
	private String role;
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public LoginModel(){}
	public LoginModel(String login, String pass, String role){
		this.login=login;
		this.pass= pass;
		this.role=role;
		
	}

}
