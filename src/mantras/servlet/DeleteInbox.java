package mantras.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mantras.usertask.UserTask;

/**
 * Servlet implementation class DeleteInbox
 */
@WebServlet("/DeleteInbox")
public class DeleteInbox extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserTask task;
	@Override
	public void init() throws ServletException {
		task=new UserTask();
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteInbox() {
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
		String[] dltinbox=request.getParameterValues("chkbox");
		System.out.println(dltinbox[0]);
		boolean status=task.deleteinbox(dltinbox);
		
		
		  if(status) { response.sendRedirect("/E-Living_Mantras/expert/inbox.jsp"); }
		 
		
	}

}
