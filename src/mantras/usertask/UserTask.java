package mantras.usertask;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import mantras.beans.ComposeMessage;
import mantras.beans.FeedBack_Bean;
import mantras.beans.Login_Credentials;
import mantras.beans.UserRegister;
import mantras.dbinfo.CrudOperation;

public class UserTask {
	
	private Connection con;

	ArrayList<ComposeMessage>inboxlist=new ArrayList<ComposeMessage>();
	ArrayList<ComposeMessage>sentitems=new ArrayList<ComposeMessage>();
	
	
	
	
	public UserRegister viewprofile(String id)
	{
		con=CrudOperation.createConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		String str="select * from userdetails where userid=?";
		
		try
		{
			ps=con.prepareStatement(str);
			ps.setString(1, id);
		rs=	ps.executeQuery();
		if(rs.next())
		{
			String userid=id;
			String username=rs.getString("name");
			String useremail=rs.getString("email");
			String useraddress=rs.getString("address");
			String userphoneno=rs.getString("phoneno");
			String usergender=rs.getString("gender");
			String userdob=rs.getString("dob");
			String photo=rs.getString("photo");
			
			UserRegister ur=new UserRegister(userid, username, useremail, useraddress, userphoneno, usergender, userdob);
			ur.setPhoto(photo);;
			
			
			
			
			
			
			return ur;
		}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	
	public ArrayList<ComposeMessage> sentitems(String id)
	{
		if(!sentitems.isEmpty())
			sentitems.clear();
		
		con=CrudOperation.createConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		String str="select * from message where senderid=? and sstatus='true'";
		
		try 
		{
			ps=con.prepareStatement(str);
			ps.setString(1, id);
			rs=ps.executeQuery();
			while(rs.next())
			{
				ComposeMessage cm=new ComposeMessage();
				cm.setSenderid(rs.getString("senderid"));
				cm.setDom(rs.getString("dom"));
				cm.setMessage(rs.getString("message"));
				cm.setSubject(rs.getString("subject"));
				cm.setReceiverid(rs.getString("receiverid"));
				cm.setMsgid(rs.getInt("msgid"));
				sentitems.add(cm);
				
			}
		}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
			return sentitems;
		
				
		
	}
	
	
	
	public ArrayList<ComposeMessage> inbox(String id)
	{
		if(!inboxlist.isEmpty())
		inboxlist.clear();
		
		
		con=CrudOperation.createConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		String str="select * from message where receiverid=? and rstatus='true'";
		
		try
		{
			ps=con.prepareStatement(str);
			ps.setString(1, id);
			rs=ps.executeQuery();
			while(rs.next())
			{
				ComposeMessage cm=new ComposeMessage();
				cm.setMsgid(rs.getInt("msgid"));
				cm.setSenderid(rs.getString("senderid"));
				cm.setReceiverid(rs.getString("receiverid"));
				cm.setSubject(rs.getString("subject"));
				cm.setMessage(rs.getString("message"));
				cm.setDom(rs.getString("dom"));
				cm.setRstatus(rs.getString("rstatus"));
				
				inboxlist.add(cm);
				
			}
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return inboxlist;
		
	}

	
	
	
	
	
	
	
	
	
	
	

	public boolean registration(UserRegister ur,Login_Credentials lc)
	{
		con=CrudOperation.createConnection();
		PreparedStatement psregister=null,pslogin=null;
		String str1="insert into userdetails(userid, name, address, email, gender, phoneno, dob) values(?,?,?,?,?,?,?)";
		String str2="insert into logindetails values(?,?,?)";
		boolean status=false;
		
		try {
			psregister=con.prepareStatement(str1);
			pslogin=con.prepareStatement(str2);
			
			psregister.setString(1, ur.getUserid());
			psregister.setString(2, ur.getUsername());
			psregister.setString(3, ur.getUseraddress());
			psregister.setString(4, ur.getUseremail());
			psregister.setString(5, ur.getUsergender());
			psregister.setString(6, ur.getUserphoneno());
			psregister.setString(7, ur.getUserdob());
			System.out.println(psregister);
			
			pslogin.setString(1, lc.getId());
			pslogin.setString(2, lc.getPassword());
			pslogin.setString(3, lc.getRole());
			System.out.println(pslogin);
			
			int a=psregister.executeUpdate();
			int b=pslogin.executeUpdate();
			
			if(a>0 && b>0)
			{
				return true;
			}
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return status;
		
		
	}












	public boolean message(ComposeMessage cm)
	{
	  con=CrudOperation.createConnection();
	  PreparedStatement ps=null;
	  boolean status=false;
	  String str="insert into message(senderid,receiverid,subject,message,dom,rstatus,sstatus) values(?,?,?,?,?,?,?)";
	  try
	  {
		  ps=con.prepareStatement(str);
		  ps.setString(1, cm.getSenderid());
		  ps.setString(2, cm.getReceiverid());
		  ps.setString(3, cm.getSubject());
		  ps.setString(4, cm.getMessage());
		  ps.setString(5, cm.getDom());
		  ps.setString(6, cm.getRstatus());
		  ps.setString(7, cm.getSstatus());
		  
		  int a=ps.executeUpdate();
		  if(a>0)
		  {
			  return true;
		  }
		  
	  }
	  catch (SQLException e) {
		e.printStackTrace();
	}
	  return status;
	  
	}



	public boolean feedback(FeedBack_Bean f)
	{
		con=CrudOperation.createConnection();
		PreparedStatement ps=null;
		boolean status=false;
		String str="insert into feedback(userid,date,feedback,expertid) value(?,?,?,?)";
		
		try
		{
			ps=con.prepareStatement(str);
			ps.setString(1, f.getUserid());
			ps.setString(2, f.getDate());
			ps.setString(3, f.getFeedback());
			ps.setString(4,f.getExpertid());
			
			int a=ps.executeUpdate();
			if(a>0)
			{
				return true;
			}
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
		
	}




	public boolean uploadprofile(File f, InputStream is, String filename)
	{
		try 
		 {
			 int size=is.available();
			 byte[]data=new byte[size];
			int status =is.read(data);
			
			FileOutputStream fos=new FileOutputStream(f+File.separator+filename );
			fos.write(data);
			fos.close();
			 	 
		 }
		 catch (IOException e)
		 {
			e.printStackTrace();
		}
		 return true;
		 
		}




	public boolean uploaddb(String id, String filename) 
	{
		con=CrudOperation.createConnection();
		PreparedStatement ps=null;
		String str="update userdetails set photo=? where userid=?";
		boolean status=false;
		
		try
		{
			ps=con.prepareStatement(str);
			ps.setString(1, filename);
			ps.setString(2, id);
		int a=	ps.executeUpdate();
		if(a>0)
		{
			return true;
		}
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return status;
	}




	public boolean deleteinbox(String[] dltinbox) 
	{
		con=CrudOperation.createConnection();
		PreparedStatement ps=null;
		String str="update message set rstatus='false' where receiverid=?";
		boolean status=false;
		
		try
		{
			ps=con.prepareStatement(str);
			
			for(int i=0;i<dltinbox.length;i++)
			{
				
				ps.setString(1, dltinbox[i]);
				ps.addBatch();
				
			}
			int[] a=ps.executeBatch();
			int f=0;
			
			for(int i=0;i<a.length;i++)
			{
				if(a[i]<0)
				{
					f=1;
					break;
				}
			}
			if(f==0)
			
				return true;
			
			
		}
		catch (SQLException e) 
		{
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return status;
		
		
	}
	
	
}
