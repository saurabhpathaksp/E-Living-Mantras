package mantras.beans;

public class ComposeMessage
{
  public String senderid,receiverid,subject,message,dom,rstatus,sstatus;
  public int msgid;

public int getMsgid() {
	return msgid;
}

public void setMsgid(int msgid) {
	this.msgid = msgid;
}

public ComposeMessage(String senderid, String receiverid, String subject, String message, String dom, String rstatus,
		String sstatus) {
	super();
	this.senderid = senderid;
	this.receiverid = receiverid;
	this.subject = subject;
	this.message = message;
	this.dom = dom;
	this.rstatus = rstatus;
	this.sstatus = sstatus;
}

public ComposeMessage() {
	super();
	// TODO Auto-generated constructor stub
}

public String getSenderid() {
	return senderid;
}

public void setSenderid(String senderid) {
	this.senderid = senderid;
}

public String getReceiverid() {
	return receiverid;
}

public void setReceiverid(String receiverid) {
	this.receiverid = receiverid;
}

public String getSubject() {
	return subject;
}

public void setSubject(String subject) {
	this.subject = subject;
}

public String getMessage() {
	return message;
}

public void setMessage(String message) {
	this.message = message;
}

public String getDom() {
	return dom;
}

public void setDom(String dom) {
	this.dom = dom;
}

public String getRstatus() {
	return rstatus;
}

public void setRstatus(String rstatus) {
	this.rstatus = rstatus;
}

public String getSstatus() {
	return sstatus;
}

public void setSstatus(String sstatus) {
	this.sstatus = sstatus;
}
}
