package mantras.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mantras.beans.ExpertRegister;
import mantras.beans.Login_Credentials;
import mantras.beans.Message;
import mantras.experttask.ExpertTask;

/**
 * Servlet implementation class ExpertRegistration
 */
@WebServlet("/ExpertRegistration")
public class ExpertRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ExpertTask task;
	@Override
	public void init() throws ServletException 
	{
		task=new ExpertTask();
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExpertRegistration() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	  String expertid=request.getParameter("expertid");
	  String expertname=request.getParameter("expertname");
	  String expertaddress=request.getParameter("expertaddress");
	  String expertemail=request.getParameter("expertemail");
	  String expertpass=request.getParameter("expertpass");
	  String expertcity=request.getParameter("expertcity");
	  String expertgender=request.getParameter("expertgender");
	  String expertphone=request.getParameter("expertphone");
	  String expertqf=request.getParameter("expertqf");
	  String expertexp=request.getParameter("expertexp");
	  String expertskill=request.getParameter("expertskill");
	  String expertcno=request.getParameter("expertcno");
	  String experttype=request.getParameter("experttype");
	  
	  ExpertRegister register=new ExpertRegister(expertid, expertname, expertaddress, expertemail, expertcity, expertgender, expertphone, expertqf, expertexp, expertskill, expertcno, experttype);
	  Login_Credentials login=new Login_Credentials(expertid, expertpass, experttype);
	
	 boolean status= task.expertregister(register,login);
	 
	 if(status)
	 {
		 request.setAttribute("msg", Message.REGISTRATION_SUCCESS);
		 RequestDispatcher dispatcher=request.getRequestDispatcher("/jsp/index.jsp");
		 dispatcher.forward(request, response);
	 }
    	
	
	
	
	
	}

}
