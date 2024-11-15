package mantra.commontask;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import mantras.beans.Login_Credentials;
import mantras.dbinfo.CrudOperation;



public class LoginTask 
{

		private Connection con;
		
		public String login(Login_Credentials lc)
		{
			con=CrudOperation.createConnection();
			PreparedStatement ps=null;
			ResultSet rs=null;
			String role="invalid";
			String login="select * from logindetails where userid=? and userpass=?";
			
			try {
				ps=con.prepareStatement(login);
				ps.setString(1, lc.getId());
				ps.setString(2, lc.getPassword());
				System.out.println(ps);
				
				rs=ps.executeQuery();
				if(rs.next()) 
				{
					role=rs.getString("usertype");
					 return role;
				}
				
				
			}
			catch(SQLException se) 
			{
				se.printStackTrace();
			}
			
			return role;
			
		}

		public boolean newregister(String userid)
		{
			con=CrudOperation.createConnection();
			PreparedStatement ps=null;
			ResultSet rs=null;
			boolean status=false;
			String str="select * from logindetails where userid=?";
			
			try
			{
				ps=con.prepareStatement(str);
				ps.setString(1, userid);
				rs=ps.executeQuery();
				if(rs.next())
				{
					return true;
				}
				
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
			return status;
			
		}
	
}

