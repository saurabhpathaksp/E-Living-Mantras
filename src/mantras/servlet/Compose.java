package mantras.servlet;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mantras.beans.ComposeMessage;
import mantras.usertask.UserTask;


/**
 * Servlet implementation class Compose
 */
@WebServlet("/Compose")
public class Compose extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	UserTask task;
	@Override
	public void init() throws ServletException 
	{
		task=new UserTask();
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Compose() {
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
		/*
		 * HttpSession hs=request.getSession(false); String
		 * id=(String)hs.getAttribute("session_id");
		 */
		
		
		
		String senderid=request.getParameter("senderid");
		String receiverid=request.getParameter("receiverid");
		String subject=request.getParameter("subject");
		String message=request.getParameter("message");
		
		
		
		
		Calendar c=Calendar.getInstance();
		int date=c.get(Calendar.DATE);
		int month=c.get(Calendar.MONTH);
		int year=c.get(Calendar.YEAR);
		
		String dom=date+"-"+(month+1)+"-"+year;
		// System.out.println(dom);
		
		ComposeMessage cm=new ComposeMessage(senderid, receiverid, subject, message, dom, "true", "true");
	boolean status=	task.message(cm);
	
	if(status)
		
	{
		response.sendRedirect("/E-Living_Mantras/user/compose.jsp");
	}
		
	}

}
