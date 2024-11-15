package mantras.dbinfo;


import java.sql.*; 


public class CrudOperation {
	private static Connection connection;
	public static Connection createConnection()
	{
	try 
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/mantra","root","root");
		
		
	}
	catch(ClassNotFoundException|SQLException se) 
	{
		se.printStackTrace();
	}
	return connection;
	}
	

}
