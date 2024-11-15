package mantras.admin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import mantras.beans.ExpertRegister;
import mantras.beans.Tipsbeans;
import mantras.beans.UserRegister;
import mantras.dbinfo.CrudOperation;

public class AdminTask {
	
	private Connection con;
	
	ArrayList<UserRegister> userlist=new  ArrayList<>();
	ArrayList<ExpertRegister>expertlist=new ArrayList<ExpertRegister>();
	
	
	
public boolean addTips(Tipsbeans tb) 
{
		
		con=CrudOperation.createConnection();
		PreparedStatement pstips=null;
		
		String strcontent="insert into addcontent(subject,tips,date) values(?,?,?)";
		try 
		{
		pstips=con.prepareStatement(strcontent);
		pstips.setString(1, tb.getSubject());
		pstips.setString(2, tb.getTips());
		pstips.setString(3, tb.getDate());
		System.out.println(pstips);
		int tips_status=pstips.executeUpdate();
		System.out.println(tips_status);
			
		}
		catch(SQLException se) 
		{
			se.printStackTrace();
		}
		
		
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public boolean deleteuser(String[] ids)
	{
	boolean status=false;
	con=CrudOperation.createConnection();
	try{
	String strdelete_user="delete from userdetails where userid=?";
	String strdelete_login="delete from logindetails where userid=?";
	PreparedStatement psuser=con.prepareStatement(strdelete_user);
	PreparedStatement pslogin=con.prepareStatement(strdelete_login);

	for(int i=0; i<ids.length;i++){
	psuser.setString(1, ids[i]);
	pslogin.setString(1,ids[i]);
	psuser.addBatch();
	pslogin.addBatch();
	}
	int[] user_status=psuser.executeBatch();
	int[] login_status=pslogin.executeBatch();
	int uflag=0, lflag=0;
	for(int i=0;i<user_status.length;i++)
	{
		if(user_status[i]<0)
		{
	uflag=1;
	break;
	}
	}
	for(int i=0;i<login_status.length;i++)
	{
		if(login_status[i]<0)
		{
	lflag=0;
	break;
	}
	}
	if(uflag==0 && lflag==0){
	status= true;

	}
	}
	catch(SQLException se){
	try{
	con.rollback();
	}catch(SQLException e){
	e.printStackTrace();
	}
	se.printStackTrace();
	}
	

	return status;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public boolean deleteexpert(String[] ids)
	{
	boolean status=false;
	con=CrudOperation.createConnection();
	try{
	String strdelete_expert="delete from expertdetails where expertid=?";
	String strdelete_login="delete from logindetails where userid=?";
	PreparedStatement psexpert=con.prepareStatement(strdelete_expert);
	PreparedStatement pslogin=con.prepareStatement(strdelete_login);
	for(int i=0;i<ids.length;i++)
	{
	psexpert.setString(1, ids[i]);
	pslogin.setString(1,ids[i]);
	psexpert.addBatch();
	pslogin.addBatch();

	}
	int[] expert_status=psexpert.executeBatch();
	int[] login_status=pslogin.executeBatch();
	int eflag=0, lflag=0;
	for(int i=0;i<expert_status.length;i++)
	{
		if(expert_status[i]<0)
		{
	eflag=1;
	break;
		}
	}
	for(int i=0;i<login_status.length;i++)
	{
		if(login_status[i]<0)
		{
	lflag=1;
	break;
	}
	}
	if(eflag==0 && lflag==0){
	status= true;

	}
	}
	catch(SQLException se){
	try{
	con.rollback();
	}catch(SQLException e){
	e.printStackTrace();
	}
	se.printStackTrace();

	}
	return status;

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public ArrayList<ExpertRegister> viewexpert()
	{
	if(!expertlist.isEmpty())
	expertlist.clear();
	
	con=CrudOperation.createConnection();
	try
	{
	String expertsql="select * from expertdetails";
	
	PreparedStatement ps=con.prepareStatement(expertsql);
	ResultSet rs=ps.executeQuery();
	while(rs.next()){
	ExpertRegister er=new ExpertRegister();
	er.setExpertid(rs.getString("expertid"));
	er.setExpertname(rs.getString("name"));
	er.setExpertaddress(rs.getString("address"));
	er.setExpertemail(rs.getString("email"));
	er.setExpertcity(rs.getString("city"));
	er.setExpertgender(rs.getString("gender"));
	er.setExpertphone(rs.getString("phone"));
	er.setExpertqf(rs.getString("qualification"));
	er.setExpertexp(rs.getString("experience"));
	er.setExpertskill(rs.getString("skills"));
	er.setExpertcno(rs.getString("certificatenumber"));
	er.setExperttype(rs.getString("experttype"));
	
	
	expertlist.add(er);
	}
	}
	catch(SQLException se){

	se.printStackTrace();
	}
	return expertlist;


	}
	
	
	
	public ArrayList<UserRegister> viewUser()
	{
	if(!userlist.isEmpty())
	userlist.clear();
	
	con=CrudOperation.createConnection();
	try
	{
	String usersql="select * from userdetails";
	
	PreparedStatement ps=con.prepareStatement(usersql);
	ResultSet rs=ps.executeQuery();
	while(rs.next()){
	UserRegister ur=new UserRegister();
	ur.setUserid(rs.getString("userid"));
	ur.setUsername(rs.getString("name"));
	ur.setUseraddress(rs.getString("address"));
	ur.setUseremail(rs.getString("email"));
	ur.setUsergender(rs.getString("gender"));
	ur.setUserphoneno(rs.getString("phoneno"));
	ur.setUserdob(rs.getString("dob"));
	
	userlist.add(ur);
	}
	}
	catch(SQLException se){

	se.printStackTrace();
	}
	return userlist;


	}


}
