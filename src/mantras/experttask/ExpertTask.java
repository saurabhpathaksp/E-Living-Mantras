package mantras.experttask;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import mantras.beans.ExpertRegister;
import mantras.beans.Login_Credentials;
import mantras.beans.ShowPost;
import mantras.dbinfo.CrudOperation;

public class ExpertTask {
	private Connection con;

	
	ArrayList<ShowPost>post=new ArrayList<ShowPost>();
	
	
	public ExpertRegister viewprofile(String id)
	{
		con=CrudOperation.createConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		String str="select * from expertdetails where expertid=?";
		
		try
		{
			ps=con.prepareStatement(str);
			ps.setString(1, id);
		rs=	ps.executeQuery();
		if(rs.next())
		{
			String expertid=id;
			String expertname=rs.getString("name");
			String expertaddress=rs.getString("address");
			String expertemail=rs.getString("email");
			String expertcity=rs.getString("city");
			String expertgender=rs.getString("gender");
			String expertphone=rs.getString("phone");
			String expertqf=rs.getString("qualification");
			String expertexp=rs.getString("experience");
			String expertskill=rs.getString("skills");
			String expertcno=rs.getString("certificatenumber");
			String experttype=rs.getString("experttype");
			
			ExpertRegister er=new ExpertRegister(expertid, expertname, expertaddress, expertemail, expertcity, expertgender, expertphone, expertqf, expertexp, expertskill, expertcno, experttype);
			return er;
		}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public ArrayList<ShowPost> viewpost()
	{
		con=CrudOperation.createConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		String str="select * from post";
		
		try
		{
			ps=con.prepareStatement(str);
			
			rs=ps.executeQuery();
			while(rs.next())
			{
				ShowPost sp=new ShowPost();
				sp.setExpertid(rs.getString("expertid"));
				sp.setCaption(rs.getString("caption"));
				sp.setDescription(rs.getString("description"));
				sp.setFilename(rs.getString("filename"));
				sp.setPostid(rs.getString("postid"));
				post.add(sp);
			}
			
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
		return(post);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public boolean expertregister(ExpertRegister er, Login_Credentials lc) 
	{
		con=CrudOperation.createConnection();
		boolean status=false;
		PreparedStatement psregister=null,pslogin=null;
		String str1="insert into expertdetails values(?,?,?,?,?,?,?,?,?,?,?,?)";
		String str2="insert into logindetails values(?,?,?)";
		try 
		{
			psregister=con.prepareStatement(str1);
			pslogin=con.prepareStatement(str2);
			
			psregister.setString(1, er.getExpertid());
			psregister.setString(2, er.getExpertname());
			psregister.setString(3, er.getExpertaddress());
			psregister.setString(4, er.getExpertemail());
			psregister.setString(5, er.getExpertcity());
			psregister.setString(6, er.getExpertgender());
			psregister.setString(7, er.getExpertphone());
			psregister.setString(8, er.getExpertqf());
			psregister.setString(9, er.getExpertexp());
			psregister.setString(10, er.getExpertskill());
			psregister.setString(11, er.getExpertcno());
			psregister.setString(12, er.getExperttype());
			
			
			pslogin.setString(1, lc.getId());
			pslogin.setString(2, lc.getPassword());
			pslogin.setString(3, lc.getRole());
			
			int a=psregister.executeUpdate();
			int b=pslogin.executeUpdate();
			
			
			if(a>0 && b>0)
			{
				return true;
			}
			
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}

	public boolean uploadDoc(InputStream is, File f, String filename) 
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

	public boolean uploadDb(String id, String filename, String desc, String caption) 
	{
		con=CrudOperation.createConnection();
	boolean	status=false;
	String str="insert into post(expertid,caption,description,filename) values(?,?,?,?)";
		
	try
	{
		PreparedStatement ps=con.prepareStatement(str);
		ps.setString(1, id);
		ps.setString(2, caption);
		ps.setString(3, desc );
		ps.setString(4, filename);
		
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
	
	

}
