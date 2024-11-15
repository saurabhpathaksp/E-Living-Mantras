  package mantras.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mantra.commontask.LoginTask;
import mantras.beans.Login_Credentials;
import mantras.beans.Message;
import mantras.beans.UserRegister;
import mantras.usertask.UserTask;

/**
 * Servlet implementation class UserRegistration
 */
@WebServlet("/UserRegistration")
public class UserRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	LoginTask task;
	UserTask task1;
	@Override
	public void init() throws ServletException {
		task=new LoginTask();
		task1=new UserTask();
	}
	
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRegistration() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		  String userid=request.getParameter("uid");
		  
		  boolean status=task.newregister(userid);
		  PrintWriter out=response.getWriter();
		  
		  if(status)
		  {
			  out.print("I'd Already exist");
			  
		  }
		  else if(userid.isEmpty())
		  {
			  out.print("");
		  }
		  else
		  {
			  out.print("looks good");
		  }
		  
		  
		  
		 
		 
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	  String userid=request.getParameter("userid");
	  String userpass=request.getParameter("userpass");
	  String username=request.getParameter("username");
	  String useremail=request.getParameter("useremail");
	  String useraddress=request.getParameter("useraddress");
	  String userphoneno=request.getParameter("userphoneno");
	  String usergender=request.getParameter("usergender");
	  String userdob=request.getParameter("userdob");
	  
	  
	  UserRegister register=new UserRegister(userid,username,useremail, useraddress, userphoneno, usergender, userdob);
	  System.out.println(register);
	  Login_Credentials login=new Login_Credentials(userid, userpass, "user");
	  
	 boolean status= task1.registration(register, login);
	 if(status==true)
	 {
		 request.setAttribute("msg", Message.REGISTRATION_SUCCESS);
		 RequestDispatcher dispatcher=request.getRequestDispatcher("/jsp/index.jsp");
		dispatcher.forward(request, response);
		
	 }
	  
	}

}
