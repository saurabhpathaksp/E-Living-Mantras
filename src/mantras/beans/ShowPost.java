package mantras.beans;

public class ShowPost {
	public ShowPost(String expertid, String caption, String description, String filename) {
		super();
		this.expertid = expertid;
		this.caption = caption;
		this.description = description;
		this.filename = filename;
	}

	public ShowPost() {
		super();
		// TODO Auto-generated constructor stub
	}

	String expertid,caption,description,filename,postid;

	public String getPostid() {
		return postid;
	}

	public void setPostid(String postid) {
		this.postid = postid;
	}

	public String getExpertid() {
		return expertid;
	}

	public void setExpertid(String expertid) {
		this.expertid = expertid;
	}

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

}
