package mantras.beans;

public class Login_Credentials 
{
private String id,password,role;

public Login_Credentials() {
	super();
	// TODO Auto-generated constructor stub
}

public Login_Credentials(String id, String password, String role) {
	super();
	this.id = id;
	this.password = password;
	this.role = role;
}

public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getRole() {
	return role;
}

public void setRole(String role) {
	this.role = role;
}

}
