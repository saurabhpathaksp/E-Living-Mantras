package mantras.beans;

public class UserRegister {
	public String userid,username,useremail,useraddress,userphoneno,usergender,userdob,photo;

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public UserRegister() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserRegister(String userid, String username, String useremail, String useraddress, String userphoneno,
			String usergender, String userdob) {
		super();
		this.userid = userid;
		this.username = username;
		this.useremail = useremail;
		this.useraddress = useraddress;
		this.userphoneno = userphoneno;
		this.usergender = usergender;
		this.userdob = userdob;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUseremail() {
		return useremail;
	}

	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}

	public String getUseraddress() {
		return useraddress;
	}

	public void setUseraddress(String useraddress) {
		this.useraddress = useraddress;
	}

	public String getUserphoneno() {
		return userphoneno;
	}

	public void setUserphoneno(String userphoneno) {
		this.userphoneno = userphoneno;
	}

	public String getUsergender() {
		return usergender;
	}

	public void setUsergender(String usergender) {
		this.usergender = usergender;
	}

	public String getUserdob() {
		return userdob;
	}

	public void setUserdob(String userdob) {
		this.userdob = userdob;
	}

}
