package mantras.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mantras.admin.AdminTask;
import mantras.beans.Message;
import mantras.beans.Tipsbeans;

/**
 * Servlet implementation class AddContent
 */
@WebServlet("/AddContent")
public class AddContent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddContent() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sub=request.getParameter("subject");
		String tip=request.getParameter("tips");
		String date=request.getParameter("date");
		
		Tipsbeans tb=new Tipsbeans(sub,tip,date);
		AdminTask task=new AdminTask();
		boolean status=task.addTips(tb);
		if(status==true) 
		{request.setAttribute("msg", Message.REGISTRATION_SUCCESS);
			RequestDispatcher dispatcher =request.getRequestDispatcher("/admin/adminhome.jsp");
			dispatcher.forward(request, response);		
		}
		else
		{
			request.setAttribute("msg", Message.REGISTRATION_FAIL);
			RequestDispatcher dispatcher =request.getRequestDispatcher("/jsp/message.jsp");
			dispatcher.forward(request, response);	
		}
		
		
	}

}
