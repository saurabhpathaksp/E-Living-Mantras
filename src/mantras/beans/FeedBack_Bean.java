package mantras.beans;

public class FeedBack_Bean {
	public String userid,expertid,feedback,date;

	public FeedBack_Bean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FeedBack_Bean(String userid, String expertid, String feedback, String date) {
		super();
		this.userid = userid;
		this.expertid = expertid;
		this.feedback = feedback;
		this.date = date;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getExpertid() {
		return expertid;
	}

	public void setExpertid(String expertid) {
		this.expertid = expertid;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
