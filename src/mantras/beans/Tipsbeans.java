package mantras.beans;

public class Tipsbeans {
	public String subject,tips,date;

	public Tipsbeans(String subject, String tips, String date) {
		super();
		this.subject = subject;
		this.tips = tips;
		this.date = date;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getTips() {
		return tips;
	}

	public void setTips(String tips) {
		this.tips = tips;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Tipsbeans() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
